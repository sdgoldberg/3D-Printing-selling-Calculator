import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.*;
import java.awt.*;
import java.awt.event.*;


public class priceCalcPanel extends JPanel implements ActionListener {
    //fields
    //different materials
    ArrayList <Materials> material = new ArrayList<Materials>();
    ArrayList <String> materialNames = new ArrayList<String>();
    Materials myNewMat;
    Materials PLA = new Materials ("Plastic (PLA)", 30, 3.00);
    Materials StainlessSteel = new Materials ("Stainless Steel", 45, 2.85);
    //priceCalculator
    priceCalculator projectPrice;

    //sellingPriceCalculator
    sellingPriceCalculator sellingPrice;

    //Strings
    String newMaterialName;
    String projectPriceString;
    String sellingPriceString;
    String PLAname;
    String StainlessName;


    //doubles
    double newMaterialPrice;
    double newMaterialKilograms;
    double thisProjectGrams;
    double thisProjectMargin;
    double thisProjectMinutes;
    double thisProjectHours;

    //buttons
    JButton newMaterial = new JButton("Create new material");
    JButton selectMaterial = new JButton("Select material");
    JButton enter;
    JButton enterTWO;
    JButton marginEnter = new JButton("Enter Margin");
    JButton marginEnterTWO = new JButton ("Enter Margin");
    JButton Reset = new JButton ("Reset");
    JButton delete = new JButton ("Delete a material");
    JButton deleteThis= new JButton ("Delete this material");


    //JLabels
/////////////////
    JLabel info = new JLabel("Enter the information below.");
    JLabel enterMaterial = new JLabel("Enter Material name");
    JLabel enterPrice = new JLabel("Enter material price");
    JLabel enterKilograms = new JLabel("Enter material Kilograms");
    JLabel answer = new JLabel(" ");
    JLabel gramsDirect = new JLabel("Enter project grams");
    JLabel marginAsk = new JLabel("What is your percent margin?");
    JLabel totalTimeDirect = new JLabel("Enter the project Time:");
    JLabel hoursDirect = new JLabel("Hours");
    JLabel minutesDirect = new JLabel ("Minutes");
    JLabel dollars = new JLabel("$");
    JLabel grams = new JLabel("grams");
    JLabel Kilograms = new JLabel ("kg");
    JLabel percent = new JLabel ("%");


//ImageIcon

//JComboBox
JComboBox <String> combo;

    //JTextFields
    /////
    JTextField materialName= new JTextField(" ");
    JTextField materialPrice= new JTextField(" ");
    JTextField materialKilograms = new JTextField(" ");
    JTextField projectGrams = new JTextField(" ");
    JTextField margin = new JTextField(" ");
    JTextField enterHours = new JTextField (" ");
    JTextField enterMinutes = new JTextField(" ");
    //
    JFrame window;
    //constructor
/////////////
    public priceCalcPanel() {
        setLayout(null);
       window = new JFrame("Harry Price Caculator");
        window.setSize(1200, 1000); // sets size of Window
        window.setResizable(false);  // makes it non-resizable
        Container c = window.getContentPane();
        c.add(this);
       //window.getContentPane().add(this); // add panel
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //  setVisible(true);


        // add to list

        material.add(PLA);
        material.add(StainlessSteel);

      PLAname = PLA.toString();
      StainlessName= StainlessSteel.toString();

      materialNames.add(PLAname);
      materialNames.add(StainlessName);

        combo = new JComboBox<String>();
        for (int i = 0; i < material.size(); i++) {
          combo.addItem(material.get(i).material);
        }
        combo.setSelectedIndex(0);
        combo.setBounds(690, 100,200,100);
        combo.setVisible(true);




        //creates button
     delete.setBounds(400, 100, 250, 100);
     delete.addActionListener(this);
     delete.setVisible(true);

        deleteThis.setBounds(300, 400, 200, 100);
        deleteThis.addActionListener(this);
        deleteThis.setVisible(false);



        newMaterial.setBounds(50, 100, 300, 100);
        newMaterial.addActionListener(this);
        newMaterial.setVisible(true);

        selectMaterial.setBounds(910, 100, 200, 100);
        selectMaterial.addActionListener(this);
        selectMaterial.setVisible(true);

        enter = new JButton("Enter");
        enter.setBounds(950, 490, 100, 100);
        enter.addActionListener(this);
        enter.setVisible(false);

       marginEnter.setBounds(340, 600, 200, 50);
       marginEnter.addActionListener(this);
       marginEnter.setVisible(false);

       answer.setBounds(600, 655, 200, 100);
       answer.setVisible(false);

       enterTWO = new JButton("Enter");
       enterTWO.setBounds(910,410,100,50);
       enterTWO.addActionListener(this);
       enterTWO.setVisible(false);

       marginEnterTWO.setBounds(370, 480, 200, 50);
       marginEnterTWO.addActionListener(this);
       marginEnterTWO.setVisible(false);

       Reset.setBounds(900, 10, 100, 50);
       Reset.addActionListener(this);
       Reset.setVisible(true);


        add(combo);
        add(Reset);
        add(answer);
        add (delete);
        add(deleteThis);
        add(newMaterial);
        add(selectMaterial);
        add(enter);
        add(enterTWO);
        add (marginEnter);
        add(marginEnterTWO);

        window.setVisible(true);


    }

    public void paintComponent(Graphics g)
    {
        Color back;
        back = Color.WHITE;

        setBackground(back);
        super.paintComponent(g);
    }

    /* //////////////
           //method to change string to double
  //////////////
  public static Double valueOf(String s){
         throws NumberFormatException
           }
           */
    public void actionPerformed(ActionEvent e) throws NumberFormatException {


        if (e.getSource().equals(newMaterial)) {
            info.setText("Enter the information below.");

            materialName.setText(" ");
            materialPrice.setText(" ");
            materialKilograms.setText(" ");
            projectGrams.setText(" ");
            marginAsk.setVisible(false);
            margin.setVisible(false);
            margin.setText(" ");
            marginEnter.setVisible(false);
            answer.setVisible(false);
            marginEnterTWO.setVisible(false);
            enterTWO.setVisible(false);
            deleteThis.setVisible(false);
            combo.setBounds(690, 100,200,100);
            enterHours.setText(" ");
            enterMinutes.setText(" ");
            percent.setVisible(false);


            info.setBounds(500, 250, 300, 100);
            info.setVisible(true);
            add(info);
            //tells user to enter material name
            enterMaterial.setBounds(100, 300, 200, 100);
            enterMaterial.setVisible(true);
            add(enterMaterial);

            materialName.setBounds(100, 400, 200, 50);
            materialName.setVisible(true);
            add(materialName);
            //tells user to enter material price

            enterPrice.setBounds(400, 300, 200, 100);
            enterPrice.setVisible(true);
            add(enterPrice);

            dollars.setBounds(380, 400, 20, 50 );
            dollars.setVisible(true);
            add(dollars);

            materialPrice.setBounds(400, 400, 100, 50);
            materialPrice.setVisible(true);
            add(materialPrice);

            //tells user to enter material length

            enterKilograms.setBounds(700, 300, 200, 100);
            enterKilograms.setVisible(true);
            add(enterKilograms);

            materialKilograms.setBounds(700, 400, 100, 50);
            materialKilograms.setVisible(true);
            add(materialKilograms);

            Kilograms.setBounds(805, 400, 50, 50);
            Kilograms.setVisible(true);
            add(Kilograms);

            gramsDirect.setBounds(50, 500, 200, 50);
            gramsDirect.setVisible(true);
            add(gramsDirect);

            projectGrams.setBounds(200, 500, 100, 50);
            projectGrams.setVisible(true);
            add(projectGrams);

            grams.setBounds(305, 500, 50, 50);
            grams.setVisible(true);
            add(grams);

            totalTimeDirect.setBounds(410, 500, 200, 50);
            totalTimeDirect.setVisible(true);
            add(totalTimeDirect);

            enterHours.setBounds(610, 500,40, 50);
            enterHours.setVisible(true);
            add(enterHours);

            hoursDirect.setBounds(655, 500, 100, 50);
            hoursDirect.setVisible(true);
            add(hoursDirect);

            enterMinutes.setBounds(760, 500, 40, 50);
            enterMinutes.setVisible(true);
            add(enterMinutes);

            minutesDirect.setBounds(805, 500, 100, 50);
            minutesDirect.setVisible(true);
            add(minutesDirect);


            enter.setVisible(true);

        }
                 if (e.getSource().equals(enter)) {
                     //Makes the JTextFields into usable strings
                     enter.setVisible(false);

                     marginAsk.setBounds(50, 600, 200, 50);
                     marginAsk.setVisible(true);
                     add(marginAsk);

                      margin.setBounds(260, 600, 50, 50);
                      margin.setVisible(true);
                      add(margin);

                      percent.setBounds(310, 600, 20, 50);
                      percent.setVisible(true);
                      add(percent);



                    newMaterialName = materialName.getText();
                    newMaterialPrice = Double.parseDouble(materialPrice.getText());
                    newMaterialKilograms = Double.parseDouble(materialKilograms.getText());
                    thisProjectGrams = Double.parseDouble(projectGrams.getText());
                    thisProjectHours = Double.parseDouble(enterHours.getText());
                    thisProjectMinutes = Double.parseDouble(enterMinutes.getText());



                    myNewMat = new Materials(newMaterialName, newMaterialPrice, newMaterialKilograms);
                    material.add(myNewMat);
                    combo.addItem(myNewMat.material);


                    projectPrice = new priceCalculator(newMaterialPrice, newMaterialKilograms, thisProjectGrams, thisProjectHours, thisProjectMinutes);
                    projectPriceString = projectPrice.toString();

                    info.setBounds(150, 655, 200,100);
                    info.setText(projectPriceString);
                    info.setVisible(true);

                    marginEnter.setVisible(true);

                }

                        if(e.getSource().equals(marginEnter)) {
                            marginEnter.setVisible(false);

                            thisProjectMargin = Double.parseDouble(margin.getText());
                            sellingPrice = new sellingPriceCalculator(newMaterialPrice, newMaterialKilograms, thisProjectGrams, thisProjectHours, thisProjectMinutes, thisProjectMargin);
                            sellingPriceString = sellingPrice.toString();

                            answer.setBounds(600, 655, 200, 100);
                            answer.setText(sellingPriceString);
                            answer.setVisible(true);
                        }

        if (e.getSource().equals(selectMaterial)) {
            info.setVisible(false);
            enterMaterial.setVisible(false);
            enterPrice.setVisible(false);
            enterKilograms.setVisible(false);
            materialName.setText(" ");
            materialName.setVisible(false);
            materialPrice.setText(" ");
            materialPrice.setVisible(false);
            materialKilograms.setText(" ");
            materialKilograms.setVisible(false);
            projectGrams.setText(" ");
            marginAsk.setVisible(false);
            margin.setVisible(false);
            margin.setText(" ");
            marginEnter.setVisible(false);
            answer.setVisible(false);
            marginEnterTWO.setVisible(false);
            enter.setVisible(false);
            deleteThis.setVisible(false);
            combo.setBounds(690, 100,200,100);
            enterHours.setText(" ");
            enterMinutes.setText(" ");
            percent.setVisible(false);
            dollars.setVisible(false);
            Kilograms.setVisible(false);
            grams.setVisible(false);



            info.setText("Enter the information below.");
            info.setBounds(500, 300, 300, 100);
            info.setVisible(true);
            add(info);

            gramsDirect.setBounds(50, 410, 200, 50);
            gramsDirect.setVisible(true);
            add(gramsDirect);

            projectGrams.setBounds(200, 410, 100, 50);
            projectGrams.setVisible(true);
            add(projectGrams);

            grams.setBounds(305, 410,50, 50);
            grams.setVisible(true);
            add(grams);

            totalTimeDirect.setBounds(430, 410, 200, 50);
            totalTimeDirect.setVisible(true);
            add(totalTimeDirect);

            enterHours.setBounds(630, 410,40, 50);
            enterHours.setVisible(true);
            add(enterHours);

            hoursDirect.setBounds(680, 410, 100, 50);
            hoursDirect.setVisible(true);
            add(hoursDirect);

            enterMinutes.setBounds(760, 410, 40, 50);
            enterMinutes.setVisible(true);
            add(enterMinutes);

            minutesDirect.setBounds(800, 410, 100, 50);
            minutesDirect.setVisible(true);
            add(minutesDirect);

            myNewMat = material.get(combo.getSelectedIndex());

            enterTWO.setVisible(true);
        }
                if(e.getSource().equals(enterTWO)) {
                    marginAsk.setBounds(50, 480, 200, 50);
                    marginAsk.setVisible(true);
                    add(marginAsk);

                    margin.setBounds(260, 480, 100, 50);
                    margin.setVisible(true);
                    add(margin);

                    thisProjectGrams = Double.parseDouble(projectGrams.getText());
                    thisProjectHours = Double.parseDouble(enterHours.getText());
                    thisProjectMinutes = Double.parseDouble(enterMinutes.getText());
                    projectPrice = new priceCalculator(myNewMat.spoolPrice, myNewMat.spoolKilograms, thisProjectGrams, thisProjectHours, thisProjectMinutes);
                    projectPriceString = projectPrice.toString();
                    info.setBounds(300, 550, 200, 100);
                    info.setText(projectPriceString);
                    info.setVisible(true);

                    marginEnterTWO.setVisible(true);
                }

                            if(e.getSource().equals(marginEnterTWO)) {
                               marginEnterTWO.setVisible(false);
                                thisProjectMargin = Double.parseDouble(margin.getText());
                                sellingPrice = new sellingPriceCalculator(myNewMat.spoolPrice, myNewMat.spoolKilograms, thisProjectGrams, thisProjectHours, thisProjectMinutes, thisProjectMargin);
                                sellingPriceString = sellingPrice.toString();

                                answer.setText(sellingPriceString);
                                answer.setBounds(600, 550, 200, 100);
                                answer.setVisible(true);
                            }

            if (e.getSource().equals(Reset)){
                info.setVisible(false);
                enterMaterial.setVisible(false);
                enterPrice.setVisible(false);
                enterKilograms.setVisible(false);
                materialName.setText(" ");
                materialName.setVisible(false);
                materialPrice.setText(" ");
                materialPrice.setVisible(false);
                materialKilograms.setText(" ");
                materialKilograms.setVisible(false);
                projectGrams.setText(" ");
                marginAsk.setVisible(false);
                margin.setVisible(false);
                margin.setText(" ");
                marginEnter.setVisible(false);
                answer.setVisible(false);
                marginEnterTWO.setVisible(false);
                enterTWO.setVisible(false);
                enter.setVisible(false);
                gramsDirect.setVisible(false);
                projectGrams.setVisible(false);
                deleteThis.setVisible(false);
                combo.setBounds(690, 100,200,100);
                totalTimeDirect.setVisible(false);
                hoursDirect.setVisible(false);
                minutesDirect.setVisible(false);
                enterHours.setVisible(false);
                enterMinutes.setVisible(false);
                enterHours.setText(" ");
                enterMinutes.setText(" ");
                percent.setVisible(false);
                dollars.setVisible(false);
                Kilograms.setVisible(false);
                grams.setVisible(false);

            }

      if(e.getSource().equals(delete)){
          enterMaterial.setVisible(false);
          enterPrice.setVisible(false);
          enterKilograms.setVisible(false);
          materialName.setText(" ");
          materialName.setVisible(false);
          materialPrice.setText(" ");
          materialPrice.setVisible(false);
          materialKilograms.setText(" ");
          materialKilograms.setVisible(false);
          projectGrams.setText(" ");
          marginAsk.setVisible(false);
          margin.setVisible(false);
          margin.setText(" ");
          marginEnter.setVisible(false);
          answer.setVisible(false);
          marginEnterTWO.setVisible(false);
          enterTWO.setVisible(false);
          enter.setVisible(false);
          gramsDirect.setVisible(false);
          projectGrams.setVisible(false);
          totalTimeDirect.setVisible(false);
          hoursDirect.setVisible(false);
          minutesDirect.setVisible(false);
          enterHours.setVisible(false);
          enterMinutes.setVisible(false);
          percent.setVisible(false);
          dollars.setVisible(false);
          Kilograms.setVisible(false);
          grams.setVisible(false);

        info.setVisible(true);
        info.setText("Pick a material to delete");
        info.setBounds(500, 350, 200, 50);
        add(info);
          combo.setBounds(600, 400,200,100);
          deleteThis.setVisible(true);
            }
                if(e.getSource().equals(deleteThis)){
                        material.remove(combo.getSelectedIndex());
                        combo.removeItemAt(combo.getSelectedIndex());
                        info.setText("Material deleted");
                        info.setBounds(500, 460, 200, 100);

                }








        repaint();
    }







    public static void main(String[] args) {
        priceCalcPanel mwd2 = new priceCalcPanel();

    }
}






