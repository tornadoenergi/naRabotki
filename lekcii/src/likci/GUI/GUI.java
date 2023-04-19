package likci.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Font;
public class GUI extends JFrame {
    private final String[] dataList = {"О языке Питон", "Синтаксис", "Переменные","Условный Оператор","Математические функции","Циклы"};
    private final String[][] dataText = {{"\t\t\t\t\tЯзык программирования\n"+ "Python 3 — это мощный инструмент для создания программ самого разнообразного назначения, доступный даже для новичков. С его помощью можно решать задачи различных типов.\n" +
            "1.\t\t\t\t\tPython 3: преимущества языка\n" +
            "1.\tPython - интерпретируемый язык программирования. С одной стороны, это позволяет значительно упростить отладку программ, с другой - обуславливает сравнительно низкую скорость выполнения.\n" +
            "2.\tДинамическая типизация. В python не надо заранее объявлять тип переменной, что очень удобно при разработке.\n" +
            "3.\tХорошая поддержка модульности. Вы можете легко написать свой модуль и использовать его в других программах.\n" +
            "4.\tВстроенная поддержка Unicode в строках. В Python необязательно писать всё на английском языке, в программах вполне может использоваться ваш родной язык.\n" +
            "5.\tПоддержка объектно-ориентированного программирования. При этом его реализация в python является одной из самых понятных.\n" +
            "6.\tАвтоматическая сборка мусора, отсутствие утечек памяти.\n" +
            "7.\tИнтеграция с C/C++, если возможностей python недостаточно.\n" +
            "8.\tПонятный и лаконичный синтаксис, способствующий ясному отображению кода. Удобная система функций позволяет при грамотном подходе создавать код, в котором будет легко разобраться\n другому человеку в случае необходимости. Также вы сможете научиться читать программы и модули, написанные другими людьми.\n" +
            "9.\tОгромное количество модулей, как входящих в стандартную поставку Python 3, так и сторонних. В некоторых случаях для написания программы достаточно лишь найти подходящие модули\n и правильно их скомбинировать. Таким образом, вы можете думать о составлении программы на более высоком уровне, работая с уже готовыми элементами, выполняющими различные действия.\n" +
            "10.\tКроссплатформенность. Программа, написанная на Python, будет функционировать совершенно одинаково вне зависимости от того, в какой операционной системе она запущена. \nОтличия возникают лишь в редких случаях, и их легко заранее предусмотреть благодаря наличию подробной документации.\n"},
           {"123","444","21","2145"},
           {"gdgd","gdg","534g","3451"}};
    private JTextPane content;
    private JPanel contentPane;
    private JList<String> lst_lekc;
    private JButton login;
    private JButton logout;
    private JButton btnLector;
    private JButton btnTest;


    public GUI() {
        setContentPane(contentPane);

  //      JFrame frame = new JFrame();
  //      JPanel contents = new JPanel();
        //String[] dataList = {"111","222","333"};
//
        //JList lst_lekc = new JList(dataList);
       // lst_lekc.add(dataList);
        lst_lekc.setListData(dataList);

        lst_lekc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       //JScrollPane myScrollPaneList = new JScrollPane(lst_lekc);
//
  //     content = new JTextArea();
  //     JScrollPane myListLector = new JScrollPane(content);
  //     //GridLayout layout = new GridLayout(1,0,2,0);
  //     JPanel buttonContainer = new JPanel();
  //     JButton btnLogin = new JButton("Войти");
  //     JButton btnLogout = new JButton("Выйти");
  //     buttonContainer.add(btnLogin);
  //     buttonContainer.add(btnLogout);
  //      // Подключения слушателя
       lst_lekc.addListSelectionListener(new listSelectionListener());
       //слушатель мыши
       lst_lekc.addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent e) {
               if (e.getClickCount() == 2) {
                   // Получение элемента
                   int selected = lst_lekc.locationToIndex(e.getPoint());
                   int i = 0;
                   String txt = "";
                   while (i < dataText[selected].length)
                       txt += dataText[selected][i++] + "\n";
                   content.setText(txt);

               }
           }
       });

        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 20);
        Font BigTema = new Font("TimesRoman",Font.BOLD,20);
        content.setFont(BigFontTR);
        lst_lekc.setFont(BigTema);
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onLogin();
            }
        });
    }
    class listSelectionListener implements ListSelectionListener {
               public void valueChanged(ListSelectionEvent e) {
                   // Выделенная строка
                   int selected = ((JList<?>)e.getSource()).
                           getSelectedIndex();
                   System.out.println ("Выделенная строка : " +
                           String.valueOf(selected));
               }
           }

    private void onLogin(){
        LoginDialog Log = new LoginDialog(this);
    }

 }
  //     });
  //   //  contents.add(buttonContainer);
  //      //contents.setLayout();
  //      contents.setBorder(new TitledBorder("Темы:"));
  //      contents.add(myScrollPaneList,BorderLayout.SOUTH);
  //      frame.setLayout();
  //     //frame.add(contents,BorderLayout.WEST);
  //     //frame.add(myListLector);
  //      CreatePane(frame.getContentPane());
  //      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.setTitle("Список лекций");
        //frame.setResizable(true);
        //frame.setVisible(true);
        //frame.setSize(800, 600);
        //frame.pack();

