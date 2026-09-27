import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/**
 * Professional Standard Calculator
 * Dark Navy + Light Royal Blue Theme
 */
public class CalculatorApp extends JFrame {

    // ============================================================
    // PROFESSIONAL COLOR PALETTE
    // ============================================================

    private final Color BACKGROUND =
            new Color(15, 23, 42);

    private final Color HEADER_BACKGROUND =
            new Color(22, 35, 58);

    private final Color BUTTON_BACKGROUND =
            new Color(65, 105, 180);

    private final Color BUTTON_HOVER =
            new Color(82, 125, 210);

    private final Color BUTTON_PRESSED =
            new Color(50, 82, 145);

    private final Color TEXT_COLOR =
            Color.WHITE;

    private final Color SECONDARY_TEXT =
            new Color(190, 205, 225);

    private final Color BORDER_COLOR =
            new Color(75, 110, 165);

    private final Color EQUALS_BACKGROUND =
            new Color(45, 115, 210);

    private final Color EQUALS_TEXT =
            Color.WHITE;

    private final Color HISTORY_BACKGROUND =
            new Color(18, 29, 48);


    // ============================================================
    // COMPONENTS
    // ============================================================

    private JTextField display;
    private JLabel expressionLabel;
    private JTextArea historyArea;

    private JPanel memoryPanel;


    // ============================================================
    // CALCULATOR
    // ============================================================

    private final Calculator calculator;


    // ============================================================
    // CALCULATION VARIABLES
    // ============================================================

    private double firstNumber = 0;

    private String operator = "";

    private boolean newNumber = true;

    private double memory = 0;

    private boolean memoryAvailable = false;


    // ============================================================
    // NUMBER FORMAT
    // ============================================================

    private final DecimalFormat formatter =
            new DecimalFormat("0.###############");


    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public CalculatorApp() {

        calculator = new Calculator();

        setTitle("Calculator");

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setMinimumSize(
                new Dimension(1000, 650)
        );

        createGUI();

        setupKeyboard();

        setExtendedState(
                JFrame.MAXIMIZED_BOTH
        );
    }


    // ============================================================
    // CREATE GUI
    // ============================================================

    private void createGUI() {

        JPanel mainPanel =
                new JPanel(new BorderLayout());

        mainPanel.setBackground(
                BACKGROUND
        );


        // HEADER

        mainPanel.add(
                createHeader(),
                BorderLayout.NORTH
        );


        // CALCULATOR + HISTORY

        JPanel centerPanel =
                new JPanel(new BorderLayout());

        centerPanel.setBackground(
                BACKGROUND
        );

        centerPanel.add(
                createCalculatorArea(),
                BorderLayout.CENTER
        );

        centerPanel.add(
                createHistoryPanel(),
                BorderLayout.EAST
        );

        mainPanel.add(
                centerPanel,
                BorderLayout.CENTER
        );

        setContentPane(mainPanel);
    }


    // ============================================================
    // HEADER
    // ============================================================

    private JPanel createHeader() {

        JPanel header =
                new JPanel(new BorderLayout());

        header.setBackground(
                HEADER_BACKGROUND
        );

        header.setPreferredSize(
                new Dimension(0, 65)
        );


        // LEFT SIDE

        JPanel left =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT,
                                18,
                                12
                        )
                );

        left.setBackground(
                HEADER_BACKGROUND
        );


        JLabel menu =
                new JLabel("☰");

        menu.setForeground(
                TEXT_COLOR
        );

        menu.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        25
                )
        );


        JLabel standard =
                new JLabel("Standard");

        standard.setForeground(
                TEXT_COLOR
        );

        standard.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        21
                )
        );


        JLabel icon =
                new JLabel("↗");

        icon.setForeground(
                SECONDARY_TEXT
        );

        icon.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        23
                )
        );


        left.add(menu);
        left.add(standard);
        left.add(icon);


        // RIGHT SIDE

        JPanel right =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                30,
                                16
                        )
                );

        right.setBackground(
                HEADER_BACKGROUND
        );


        JLabel history =
                new JLabel("History");

        history.setForeground(
                SECONDARY_TEXT
        );

        history.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16
                )
        );


        JLabel memory =
                new JLabel("Memory");

        memory.setForeground(
                SECONDARY_TEXT
        );

        memory.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16
                )
        );


        right.add(history);
        right.add(memory);


        header.add(
                left,
                BorderLayout.WEST
        );

        header.add(
                right,
                BorderLayout.EAST
        );


        return header;
    }


    // ============================================================
    // MAIN CALCULATOR AREA
    // ============================================================

    private JPanel createCalculatorArea() {

        JPanel panel =
                new JPanel(new BorderLayout());

        panel.setBackground(
                BACKGROUND
        );


        // DISPLAY

        panel.add(
                createDisplay(),
                BorderLayout.CENTER
        );


        // BOTTOM AREA

        JPanel bottom =
                new JPanel(new BorderLayout());

        bottom.setBackground(
                BACKGROUND
        );


        memoryPanel =
                createMemoryPanel();

        bottom.add(
                memoryPanel,
                BorderLayout.NORTH
        );


        bottom.add(
                createKeypad(),
                BorderLayout.CENTER
        );


        panel.add(
                bottom,
                BorderLayout.SOUTH
        );


        return panel;
    }


    // ============================================================
    // DISPLAY
    // ============================================================

    private JPanel createDisplay() {

        JPanel panel =
                new JPanel(new BorderLayout());

        panel.setBackground(
                BACKGROUND
        );

        panel.setBorder(
                new EmptyBorder(
                        30,
                        35,
                        10,
                        35
                )
        );


        expressionLabel =
                new JLabel(" ");

        expressionLabel.setHorizontalAlignment(
                SwingConstants.RIGHT
        );

        expressionLabel.setForeground(
                SECONDARY_TEXT
        );

        expressionLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        18
                )
        );


        display =
                new JTextField("0");

        display.setEditable(false);

        display.setHorizontalAlignment(
                SwingConstants.RIGHT
        );

        display.setBackground(
                BACKGROUND
        );

        display.setForeground(
                TEXT_COLOR
        );

        display.setCaretColor(
                TEXT_COLOR
        );

        display.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        60
                )
        );

        display.setBorder(null);


        panel.add(
                expressionLabel,
                BorderLayout.NORTH
        );

        panel.add(
                display,
                BorderLayout.CENTER
        );


        return panel;
    }


    // ============================================================
    // MEMORY PANEL
    // ============================================================

    private JPanel createMemoryPanel() {

        JPanel panel =
                new JPanel(
                        new GridLayout(
                                1,
                                5,
                                0,
                                0
                        )
                );

        panel.setBackground(
                BACKGROUND
        );

        panel.setBorder(
                new EmptyBorder(
                        5,
                        20,
                        8,
                        20
                )
        );


        String[] buttons = {
                "MC",
                "MR",
                "M+",
                "M−",
                "MS"
        };


        for (String text : buttons) {

            JButton button =
                    createMemoryButton(text);

            panel.add(button);
        }


        return panel;
    }


    // ============================================================
    // MEMORY BUTTON
    // ============================================================

    private JButton createMemoryButton(
            String text) {

        JButton button =
                new JButton(text);

        // Prevent Windows Look & Feel
        // from overriding the colors.

        button.setUI(
                new javax.swing.plaf.basic.BasicButtonUI()
        );

        button.setOpaque(true);

        button.setContentAreaFilled(true);

        button.setFocusPainted(false);

        button.setRolloverEnabled(false);

        button.setBackground(
                BACKGROUND
        );

        button.setForeground(
                SECONDARY_TEXT
        );

        button.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        15
                )
        );

        button.setBorder(null);


        button.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            MouseEvent e) {

                        button.setForeground(
                                TEXT_COLOR
                        );
                    }

                    @Override
                    public void mouseExited(
                            MouseEvent e) {

                        button.setForeground(
                                SECONDARY_TEXT
                        );
                    }
                }
        );


        button.addActionListener(
                e -> memoryOperation(text)
        );


        return button;
    }


    // ============================================================
    // KEYPAD
    // ============================================================

    private JPanel createKeypad() {

        JPanel panel =
                new JPanel(
                        new GridLayout(
                                6,
                                4,
                                3,
                                3
                        )
                );

        panel.setBackground(
                BACKGROUND
        );

        panel.setBorder(
                new EmptyBorder(
                        5,
                        5,
                        5,
                        5
                )
        );


        // ROW 1

        panel.add(
                createButton(
                        "%",
                        "function"
                )
        );

        panel.add(
                createButton(
                        "CE",
                        "function"
                )
        );

        panel.add(
                createButton(
                        "C",
                        "function"
                )
        );

        panel.add(
                createButton(
                        "⌫",
                        "function"
                )
        );


        // ROW 2

        panel.add(
                createButton(
                        "1/x",
                        "function"
                )
        );

        panel.add(
                createButton(
                        "x²",
                        "function"
                )
        );

        panel.add(
                createButton(
                        "²√x",
                        "function"
                )
        );

        panel.add(
                createButton(
                        "÷",
                        "operator"
                )
        );


        // ROW 3

        panel.add(
                createButton(
                        "7",
                        "number"
                )
        );

        panel.add(
                createButton(
                        "8",
                        "number"
                )
        );

        panel.add(
                createButton(
                        "9",
                        "number"
                )
        );

        panel.add(
                createButton(
                        "×",
                        "operator"
                )
        );


        // ROW 4

        panel.add(
                createButton(
                        "4",
                        "number"
                )
        );

        panel.add(
                createButton(
                        "5",
                        "number"
                )
        );

        panel.add(
                createButton(
                        "6",
                        "number"
                )
        );

        panel.add(
                createButton(
                        "−",
                        "operator"
                )
        );


        // ROW 5

        panel.add(
                createButton(
                        "1",
                        "number"
                )
        );

        panel.add(
                createButton(
                        "2",
                        "number"
                )
        );

        panel.add(
                createButton(
                        "3",
                        "number"
                )
        );

        panel.add(
                createButton(
                        "+",
                        "operator"
                )
        );


        // ROW 6

        panel.add(
                createButton(
                        "+/−",
                        "function"
                )
        );

        panel.add(
                createButton(
                        "0",
                        "number"
                )
        );

        panel.add(
                createButton(
                        ".",
                        "number"
                )
        );

        panel.add(
                createButton(
                        "=",
                        "equals"
                )
        );


        return panel;
    }


    // ============================================================
    // CREATE CALCULATOR BUTTON
    // FIXED VERSION
    // ============================================================

    private JButton createButton(
            String text,
            String type) {

        JButton button =
                new JButton(text);


        // --------------------------------------------------------
        // IMPORTANT FIX
        // --------------------------------------------------------
        // This prevents the Windows Look & Feel from
        // overriding our custom button colors.
        // --------------------------------------------------------

        button.setUI(
                new javax.swing.plaf.basic.BasicButtonUI()
        );

        button.setOpaque(true);

        button.setContentAreaFilled(true);

        button.setFocusPainted(false);

        button.setRolloverEnabled(false);


        // --------------------------------------------------------
        // BORDER
        // --------------------------------------------------------

        button.setBorder(
                BorderFactory.createLineBorder(
                        BORDER_COLOR,
                        1
                )
        );


        // --------------------------------------------------------
        // FONT
        // --------------------------------------------------------

        int fontSize = 21;

        if (text.equals("=")) {

            fontSize = 24;
        }

        if (type.equals("function")) {

            fontSize = 19;
        }


        button.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        fontSize
                )
        );


        // --------------------------------------------------------
        // INITIAL COLORS
        // --------------------------------------------------------

        setNormalButtonColor(
                button,
                type
        );


        // --------------------------------------------------------
        // MOUSE EFFECTS
        // --------------------------------------------------------

        button.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            MouseEvent e) {

                        if (type.equals("equals")) {

                            button.setBackground(
                                    new Color(
                                            65,
                                            135,
                                            230
                                    )
                            );

                        } else {

                            button.setBackground(
                                    BUTTON_HOVER
                            );
                        }


                        button.setForeground(
                                Color.WHITE
                        );
                    }


                    @Override
                    public void mouseExited(
                            MouseEvent e) {

                        setNormalButtonColor(
                                button,
                                type
                        );
                    }


                    @Override
                    public void mousePressed(
                            MouseEvent e) {

                        button.setBackground(
                                BUTTON_PRESSED
                        );

                        button.setForeground(
                                Color.WHITE
                        );
                    }


                    @Override
                    public void mouseReleased(
                            MouseEvent e) {

                        if (button.getModel().isRollover()) {

                            if (type.equals("equals")) {

                                button.setBackground(
                                        new Color(
                                                65,
                                                135,
                                                230
                                        )
                                );

                            } else {

                                button.setBackground(
                                        BUTTON_HOVER
                                );
                            }

                        } else {

                            setNormalButtonColor(
                                    button,
                                    type
                            );
                        }


                        button.setForeground(
                                Color.WHITE
                        );
                    }
                }
        );


        // --------------------------------------------------------
        // ACTION
        // --------------------------------------------------------

        button.addActionListener(
                e -> processButton(text)
        );


        return button;
    }


    // ============================================================
    // SET NORMAL BUTTON COLOR
    // ============================================================

    private void setNormalButtonColor(
            JButton button,
            String type) {

        if (type.equals("equals")) {

            button.setBackground(
                    EQUALS_BACKGROUND
            );

            button.setForeground(
                    Color.WHITE
            );

        } else if (type.equals("operator")) {

            button.setBackground(
                    BUTTON_BACKGROUND
            );

            button.setForeground(
                    Color.WHITE
            );

        } else if (type.equals("function")) {

            button.setBackground(
                    new Color(
                            48,
                            78,
                            125
                    )
            );

            button.setForeground(
                    Color.WHITE
            );

        } else {

            button.setBackground(
                    new Color(
                            55,
                            88,
                            135
                    )
            );

            button.setForeground(
                    Color.WHITE
            );
        }
    }


    // ============================================================
    // HISTORY PANEL
    // ============================================================

    private JPanel createHistoryPanel() {

        JPanel panel =
                new JPanel(
                        new BorderLayout()
                );

        panel.setBackground(
                HISTORY_BACKGROUND
        );

        panel.setPreferredSize(
                new Dimension(
                        340,
                        0
                )
        );

        panel.setBorder(
                BorderFactory.createMatteBorder(
                        0,
                        1,
                        0,
                        0,
                        BORDER_COLOR
                )
        );


        // TITLE PANEL

        JPanel titlePanel =
                new JPanel(
                        new BorderLayout()
                );

        titlePanel.setBackground(
                HISTORY_BACKGROUND
        );

        titlePanel.setBorder(
                new EmptyBorder(
                        15,
                        20,
                        10,
                        15
                )
        );


        JLabel title =
                new JLabel("History");

        title.setForeground(
                TEXT_COLOR
        );

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        17
                )
        );


        // CLEAR BUTTON

        JButton clear =
                new JButton("🗑");

        clear.setUI(
                new javax.swing.plaf.basic.BasicButtonUI()
        );

        clear.setOpaque(true);

        clear.setContentAreaFilled(true);

        clear.setBackground(
                HISTORY_BACKGROUND
        );

        clear.setForeground(
                SECONDARY_TEXT
        );

        clear.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        17
                )
        );

        clear.setBorder(null);

        clear.setFocusPainted(false);


        clear.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            MouseEvent e) {

                        clear.setForeground(
                                TEXT_COLOR
                        );
                    }

                    @Override
                    public void mouseExited(
                            MouseEvent e) {

                        clear.setForeground(
                                SECONDARY_TEXT
                        );
                    }
                }
        );


        clear.addActionListener(
                e -> clearHistory()
        );


        titlePanel.add(
                title,
                BorderLayout.WEST
        );

        titlePanel.add(
                clear,
                BorderLayout.EAST
        );


        panel.add(
                titlePanel,
                BorderLayout.NORTH
        );


        // HISTORY TEXT

        historyArea =
                new JTextArea();

        historyArea.setEditable(false);

        historyArea.setLineWrap(true);

        historyArea.setWrapStyleWord(true);

        historyArea.setBackground(
                HISTORY_BACKGROUND
        );

        historyArea.setForeground(
                TEXT_COLOR
        );

        historyArea.setCaretColor(
                TEXT_COLOR
        );

        historyArea.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16
                )
        );

        historyArea.setBorder(
                new EmptyBorder(
                        10,
                        20,
                        10,
                        20
                )
        );


        JScrollPane scrollPane =
                new JScrollPane(
                        historyArea
                );

        scrollPane.setBorder(null);

        scrollPane.setBackground(
                HISTORY_BACKGROUND
        );


        panel.add(
                scrollPane,
                BorderLayout.CENTER
        );


        return panel;
    }


    // ============================================================
    // PROCESS BUTTON
    // ============================================================

    private void processButton(
            String button) {

        // NUMBER

        if (button.matches("[0-9]")) {

            enterNumber(button);

            return;
        }


        // DECIMAL

        if (button.equals(".")) {

            enterDecimal();

            return;
        }


        // OPERATORS

        if (button.equals("+")
                || button.equals("−")
                || button.equals("×")
                || button.equals("÷")) {

            chooseOperator(button);

            return;
        }


        // EQUALS

        if (button.equals("=")) {

            calculate();

            return;
        }


        // CLEAR

        if (button.equals("C")) {

            clearAll();

            return;
        }


        // CLEAR ENTRY

        if (button.equals("CE")) {

            clearEntry();

            return;
        }


        // BACKSPACE

        if (button.equals("⌫")) {

            backspace();

            return;
        }


        // SIGN

        if (button.equals("+/−")) {

            changeSign();

            return;
        }


        // PERCENTAGE

        if (button.equals("%")) {

            percentage();

            return;
        }


        // RECIPROCAL

        if (button.equals("1/x")) {

            reciprocal();

            return;
        }


        // SQUARE

        if (button.equals("x²")) {

            square();

            return;
        }


        // SQUARE ROOT

        if (button.equals("²√x")) {

            squareRoot();
        }
    }


    // ============================================================
    // ENTER NUMBER
    // ============================================================

    private void enterNumber(
            String number) {

        if (newNumber
                || display.getText().equals("0")
                || display.getText().equals("Error")) {

            display.setText(number);

            newNumber = false;

        } else {

            display.setText(
                    display.getText() + number
            );
        }
    }


    // ============================================================
    // DECIMAL
    // ============================================================

    private void enterDecimal() {

        if (newNumber
                || display.getText().equals("Error")) {

            display.setText("0.");

            newNumber = false;

            return;
        }


        if (!display.getText().contains(".")) {

            display.setText(
                    display.getText() + "."
            );
        }
    }


    // ============================================================
    // OPERATOR
    // ============================================================

    private void chooseOperator(
            String selectedOperator) {

        double current =
                getDisplayValue();


        if (!operator.isEmpty()
                && !newNumber) {

            try {

                firstNumber =
                        calculator.calculate(
                                firstNumber,
                                current,
                                operator
                        );

                display.setText(
                        format(firstNumber)
                );

            } catch (ArithmeticException e) {

                showError(
                        e.getMessage()
                );

                return;
            }

        } else {

            firstNumber = current;
        }


        operator = selectedOperator;

        newNumber = true;


        expressionLabel.setText(
                format(firstNumber)
                        + " "
                        + operator
        );
    }


    // ============================================================
    // CALCULATE
    // ============================================================

    private void calculate() {

        if (operator.isEmpty()) {

            return;
        }


        double secondNumber =
                getDisplayValue();


        try {

            double result =
                    calculator.calculate(
                            firstNumber,
                            secondNumber,
                            operator
                    );


            String expression =
                    format(firstNumber)
                            + " "
                            + operator
                            + " "
                            + format(secondNumber)
                            + " =";


            String resultText =
                    format(result);


            display.setText(
                    resultText
            );


            expressionLabel.setText(
                    expression
            );


            addHistory(
                    expression,
                    resultText
            );


            firstNumber = result;

            operator = "";

            newNumber = true;


        } catch (ArithmeticException e) {

            showError(
                    e.getMessage()
            );
        }
    }


    // ============================================================
    // CLEAR ALL
    // ============================================================

    private void clearAll() {

        display.setText("0");

        expressionLabel.setText(" ");

        firstNumber = 0;

        operator = "";

        newNumber = true;
    }


    // ============================================================
    // CLEAR ENTRY
    // ============================================================

    private void clearEntry() {

        display.setText("0");

        newNumber = true;
    }


    // ============================================================
    // BACKSPACE
    // ============================================================

    private void backspace() {

        if (newNumber) {

            return;
        }


        String value =
                display.getText();


        if (value.length() <= 1
                || (value.length() == 2
                && value.startsWith("-"))) {

            display.setText("0");

            newNumber = true;

        } else {

            display.setText(
                    value.substring(
                            0,
                            value.length() - 1
                    )
            );
        }
    }


    // ============================================================
    // SIGN
    // ============================================================

    private void changeSign() {

        if (display.getText().equals("0")
                || display.getText().equals("Error")) {

            return;
        }


        String value =
                display.getText();


        if (value.startsWith("-")) {

            display.setText(
                    value.substring(1)
            );

        } else {

            display.setText(
                    "-" + value
            );
        }
    }


    // ============================================================
    // PERCENTAGE
    // ============================================================

    private void percentage() {

        try {

            double value =
                    getDisplayValue();

            double result;


            if (!operator.isEmpty()) {

                result =
                        firstNumber
                                * value
                                / 100.0;

            } else {

                result =
                        calculator.percentage(
                                value
                        );
            }


            display.setText(
                    format(result)
            );

            newNumber = true;


        } catch (Exception e) {

            showError(
                    "Invalid input"
            );
        }
    }


    // ============================================================
    // RECIPROCAL
    // ============================================================

    private void reciprocal() {

        try {

            double value =
                    getDisplayValue();


            double result =
                    calculator.reciprocal(
                            value
                    );


            String expression =
                    "1 / "
                            + format(value)
                            + " =";


            display.setText(
                    format(result)
            );


            expressionLabel.setText(
                    expression
            );


            addHistory(
                    expression,
                    format(result)
            );


            newNumber = true;


        } catch (ArithmeticException e) {

            showError(
                    e.getMessage()
            );
        }
    }


    // ============================================================
    // SQUARE
    // ============================================================

    private void square() {

        double value =
                getDisplayValue();


        double result =
                calculator.square(
                        value
                );


        String expression =
                format(value)
                        + "² =";


        display.setText(
                format(result)
        );


        expressionLabel.setText(
                expression
        );


        addHistory(
                expression,
                format(result)
        );


        newNumber = true;
    }


    // ============================================================
    // SQUARE ROOT
    // ============================================================

    private void squareRoot() {

        try {

            double value =
                    getDisplayValue();


            double result =
                    calculator.squareRoot(
                            value
                    );


            String expression =
                    "√("
                            + format(value)
                            + ") =";


            display.setText(
                    format(result)
            );


            expressionLabel.setText(
                    expression
            );


            addHistory(
                    expression,
                    format(result)
            );


            newNumber = true;


        } catch (ArithmeticException e) {

            showError(
                    e.getMessage()
            );
        }
    }


    // ============================================================
    // MEMORY
    // ============================================================

    private void memoryOperation(
            String operation) {

        double current =
                getDisplayValue();


        switch (operation) {

            case "MC":

                memory = 0;

                memoryAvailable = false;

                break;


            case "MR":

                if (memoryAvailable) {

                    display.setText(
                            format(memory)
                    );

                    newNumber = true;
                }

                break;


            case "M+":

                memory += current;

                memoryAvailable = true;

                break;


            case "M−":

                memory -= current;

                memoryAvailable = true;

                break;


            case "MS":

                memory = current;

                memoryAvailable = true;

                break;
        }


        updateMemoryButtons();
    }


    // ============================================================
    // UPDATE MEMORY BUTTONS
    // ============================================================

    private void updateMemoryButtons() {

        for (Component component :
                memoryPanel.getComponents()) {

            if (component instanceof JButton) {

                JButton button =
                        (JButton) component;


                if ((button.getText().equals("MC")
                        || button.getText().equals("MR"))
                        && !memoryAvailable) {

                    button.setForeground(
                            new Color(
                                    120,
                                    140,
                                    165
                            )
                    );

                } else {

                    button.setForeground(
                            SECONDARY_TEXT
                    );
                }
            }
        }
    }


    // ============================================================
    // ADD HISTORY
    // ============================================================

    private void addHistory(
            String expression,
            String result) {

        String current =
                historyArea.getText();


        String newHistory =
                expression
                        + "\n"
                        + result
                        + "\n\n"
                        + current;


        historyArea.setText(
                newHistory
        );
    }


    // ============================================================
    // CLEAR HISTORY
    // ============================================================

    private void clearHistory() {

        historyArea.setText("");
    }


    // ============================================================
    // GET DISPLAY VALUE
    // ============================================================

    private double getDisplayValue() {

        try {

            return Double.parseDouble(
                    display.getText()
            );

        } catch (Exception e) {

            return 0;
        }
    }


    // ============================================================
    // FORMAT NUMBER
    // ============================================================

    private String format(
            double number) {

        if (Double.isNaN(number)
                || Double.isInfinite(number)) {

            return "Error";
        }


        return formatter.format(number);
    }


    // ============================================================
    // ERROR
    // ============================================================

    private void showError(
            String message) {

        display.setText("Error");

        expressionLabel.setText(
                message
        );

        firstNumber = 0;

        operator = "";

        newNumber = true;
    }


    // ============================================================
    // KEYBOARD SUPPORT
    // ============================================================

    private void setupKeyboard() {

        KeyboardFocusManager
                .getCurrentKeyboardFocusManager()
                .addKeyEventDispatcher(
                        event -> {

                            if (event.getID()
                                    != KeyEvent.KEY_PRESSED) {

                                return false;
                            }


                            char key =
                                    event.getKeyChar();

                            int code =
                                    event.getKeyCode();


                            // NUMBERS

                            if (key >= '0'
                                    && key <= '9') {

                                processButton(
                                        String.valueOf(key)
                                );

                                return false;
                            }


                            // DECIMAL

                            if (key == '.') {

                                processButton(".");

                                return false;
                            }


                            // PLUS

                            if (key == '+') {

                                processButton("+");

                                return false;
                            }


                            // MINUS

                            if (key == '-') {

                                processButton("−");

                                return false;
                            }


                            // MULTIPLY

                            if (key == '*') {

                                processButton("×");

                                return false;
                            }


                            // DIVIDE

                            if (key == '/') {

                                processButton("÷");

                                return false;
                            }


                            // ENTER

                            if (code == KeyEvent.VK_ENTER) {

                                processButton("=");

                                return false;
                            }


                            // BACKSPACE

                            if (code ==
                                    KeyEvent.VK_BACK_SPACE) {

                                processButton("⌫");

                                return false;
                            }


                            // ESCAPE

                            if (code ==
                                    KeyEvent.VK_ESCAPE) {

                                processButton("C");

                                return false;
                            }


                            return false;
                        }
                );
    }


    // ============================================================
    // MAIN
    // ============================================================

    public static void main(
            String[] args) {

        try {

            UIManager.setLookAndFeel(
                    UIManager
                            .getSystemLookAndFeelClassName()
            );

        } catch (Exception ignored) {
        }


        SwingUtilities.invokeLater(() -> {

            CalculatorApp app =
                    new CalculatorApp();

            app.setVisible(true);
        });
    }
}