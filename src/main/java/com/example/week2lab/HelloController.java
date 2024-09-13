package com.example.week2lab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class HelloController {

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
        idiotLabel.setText("I don't know the loan formula : v)");
    }

    protected double calculateMonthlyPayments(double rate, double loan){
        double monthlySum = -1.0;
        monthlySum = (double) (rate * loan) /12;
        return monthlySum;
    }
    protected double calculateTotalPayment(double rate, double years, double loan){
        double monthly = calculateMonthlyPayments(rate, loan);
        return monthly * years;
    }
}