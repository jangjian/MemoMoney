package MemoMoney;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Memo extends JFrame {
    static JPanel p1 = new JPanel() {
        Image background = new ImageIcon(Memo.class.getResource("../Image/Memo_p.png")).getImage();

        public void paintComponent(Graphics g) {
            g.drawImage(background, 0, 0, null);
            setOpaque(false);
            super.paintComponent(g);
        }
    };

    /*소비내역*/
    private JTextArea[] textAreas = new JTextArea[4];
    private JLabel sumLabel = new JLabel();

    /*일기장*/
    JTextArea textArea = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(textArea);

    /*저장버튼*/
    JButton saveButton = new JButton("");

    /*뒤로가기 버튼*/
    JButton backButton = new JButton("");

    /*날짜 라벨*/
    JLabel selectedDateLabel = new JLabel(); // 라벨 추가

    private String selectedDate; // 새로운 멤버 변수 추가

    Memo(String selectedDate) {
        setTitle("MemoMoney");

        this.selectedDate = selectedDate; // 전달받은 날짜를 저장

        Font font = new Font("나눔손글씨 장미체", Font.PLAIN, 30);
        Font font1 = new Font("나눔손글씨 장미체", Font.PLAIN, 30);
        Color font1Color = Color.WHITE; // 폰트 색을 하얀색으로 설정
        textArea.setFont(font);

        /*저장버튼*/
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveText1();
                saveText2();
            }
        });
        saveButton.setBounds(1205, 20, 40, 40);     //saveButton 위치 설정
        saveButton.setContentAreaFilled(false);    //saveButton 배경 투명화
        saveButton.setBorderPainted(false);         //saveButton 테두리 투명화

        /*뒤로가기 버튼*/
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Calendar_p();
                setVisible(false);
            }
        });
        backButton.setBounds(20, 20, 40, 40);     //backButton 위치 설정
        backButton.setContentAreaFilled(false);    //backButton 배경 투명화
        backButton.setBorderPainted(false);         //backButton 테두리 투명화

        // 라벨 초기화
        selectedDateLabel.setFont(font1);
        selectedDateLabel.setForeground(font1Color);
        selectedDateLabel.setBounds(65, 16, 400, 40);
        p1.add(selectedDateLabel);

        // 날짜 설정
        if (!selectedDate.isEmpty()) {
            selectedDateLabel.setText(selectedDate);
        }

     // 선택된 날짜에 대한 기존 메모 불러오기
        loadMemos(selectedDate);
        

        p1.setLayout(null);
        p1.add(scrollPane);
        p1.add(saveButton);
        p1.add(backButton);

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);    // 가로 스크롤 X
        scrollPane.setBounds(45, 185, 505, 480);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        textArea.setLineWrap(true);        // 자동 줄바꿈
        textArea.setOpaque(false);
        scrollPane.setVisible(true);

        for (int i = 0; i < 4; i++) {
            textAreas[i] = new JTextArea();
            textAreas[i].setFont(font);

            int x = (i < 4) ? 740 : 600; 
            int y = (i % 4) * 60 + 280;   
            textAreas[i].setBounds(x, y, 500, 40);

            textAreas[i].setOpaque(false);	
            textAreas[i].setBorder(null);
            textAreas[i].setOpaque(false);

            p1.add(textAreas[i]);
        }

        sumLabel.setFont(font);
        p1.add(sumLabel);
        sumLabel.setBounds(650, 515, 200, 60);

        p1.setLayout(null);

        add(p1);
        setSize(1290, 750);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 텍스트 영역에 대한 액션 리스너 추가하여 입력이 발생할 때마다 합계 계산
        for (JTextArea area : textAreas) {
            area.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
                public void changedUpdate(javax.swing.event.DocumentEvent e) {
                    updateSum();
                }

                public void removeUpdate(javax.swing.event.DocumentEvent e) {
                    updateSum();
                }

                public void insertUpdate(javax.swing.event.DocumentEvent e) {
                    updateSum();
                }
            });
        }

        updateSum();
    }

    private void updateSum() {
        int sum = calculateSum();
        displaySum(sum);
    }

    private int calculateSum() {
        int sum = 0;

        for (JTextArea area : textAreas) {
            String areaText = area.getText();
            if (!areaText.trim().isEmpty()) {
                try {
                    int value = Integer.parseInt(areaText);
                    sum += value;
                } catch (NumberFormatException e) {
                    // 예외 처리: 숫자로 변환할 수 없는 경우
                    System.out.println("숫자로 변환 중 오류 발생: " + e.getMessage());
                }
            }
        }

        return sum;
    }

    // 파일에서 메모를 불러오는 메소드
    void loadMemos(String selectedDate) {
        try {
            File memoFile = new File("C:/eclipse/MemoMoney/Memo_" + selectedDate + ".txt");
            if (memoFile.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(memoFile));
                StringBuilder memoContent = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    memoContent.append(line).append("\n");
                }
                textArea.setText(memoContent.toString());
                reader.close();
            }

            for (int i = 0; i < 4; i++) {
            	if (textAreas[i] != null) {
                memoFile = new File("C:/eclipse/MemoMoney/Memo_" + selectedDate + "_" + (i + 1) + ".txt");
                if (memoFile.exists()) {
                    BufferedReader reader = new BufferedReader(new FileReader(memoFile));
                    StringBuilder memoContent = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        memoContent.append(line).append("\n");
                    }
                    textAreas[i].setText(memoContent.toString());
                    reader.close();
                	} 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void saveText1() {
        try {
            String directoryPath = "C:/eclipse/MemoMoney/";
            File directory = new File(directoryPath);
            JOptionPane.showMessageDialog(null, "성공적으로 저장하였습니다.", "MemoMoney", JOptionPane.ERROR_MESSAGE);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            String memoFilePath = directoryPath + "Memo_" + selectedDate + ".txt";
            FileWriter writer = new FileWriter(memoFilePath);
            writer.write(textArea.getText());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveText2() {
        try {
            for (int i = 0; i < 4; i++) {
                String directoryPath = "C:/eclipse/MemoMoney/";
                File directory = new File(directoryPath);
                if (!directory.exists()) {
                    directory.mkdirs();
                }
                String memoFilePath = directoryPath + "Memo_" + selectedDate + "_" + (i + 1) + ".txt";
                FileWriter writer = new FileWriter(memoFilePath);
                writer.write(textAreas[i].getText());
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displaySum(int sum) {
        sumLabel.setText(sum + "원");

        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        new Memo("");
    }
}
