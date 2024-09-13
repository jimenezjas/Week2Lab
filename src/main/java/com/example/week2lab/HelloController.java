package com.example.week2lab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class HelloController {
    //initialization of working parts of the application, the @FXML tag allows the program to inherit the actual text information from the user interface.
    @FXML
    private TextField AnnualRateField;
    @FXML
    private TextField NumYearsField;
    @FXML
    private TextField LoanField;
    @FXML
    private TextField MonthlyField;
    @FXML
    private TextField TotalField;
    @FXML
    private Button calculateButton;
    @FXML
    private Label idiotLabel;
    //on button press, read in text from all 3 text fields and use them in the formula. Afterward, give the values to the monthly and total payment fields.
    @FXML
    protected void calculatePayments(ActionEvent event){
    String rate = AnnualRateField.getText();
    String years = NumYearsField.getText();
    String loan = LoanField.getText();

        String monthly = "$";
        monthly = monthly + calculateMonthlyPayments(parseDouble(rate),parseDouble(loan));
        String yearly = "$";
        yearly = yearly + calculateTotalPayment(parseDouble(rate),parseDouble(years),parseDouble(loan));

        MonthlyField.setText(monthly);
        TotalField.setText(yearly);
        //I tried to use the numbers you used in the example and got something different, I guess I used the wrong formula
        idiotLabel.setText("I don't know the loan formula : v)");
    }
    //called when doing the calculation for each month's payment.
    protected double calculateMonthlyPayments(double rate, double loan){
        double monthlySum = -1.0;
        monthlySum = (double) (rate * loan) /12;
        return monthlySum;
    }
    //called when doing the total payment by multiplying the monthly payment by the yearly amount (and 12 months)
    protected double calculateTotalPayment(double rate, double years, double loan){
        double monthly = calculateMonthlyPayments(rate, loan);
        return monthly * 12 * years;
    }
}