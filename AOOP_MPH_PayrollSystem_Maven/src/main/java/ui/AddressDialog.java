/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

/**
 *
 * @author danilo
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddressDialog extends JDialog {
    private JTextField streetField, barangayField, cityField, provinceField, zipField;
    private boolean confirmed = false;

    public AddressDialog(JFrame parent, String address) {
        super(parent, "Enter Address", true);
        setLayout(new GridLayout(6, 2, 5, 5));

        streetField = new JTextField();
        barangayField = new JTextField();
        cityField = new JTextField();
        provinceField = new JTextField();
        zipField = new JTextField();

        // If editing, populate fields
        String[] parts = address != null ? address.split(";", -1) : new String[0];
        if (parts.length > 0) streetField.setText(parts[0].trim());
        if (parts.length > 1) barangayField.setText(parts[1].trim());
        if (parts.length > 2) cityField.setText(parts[2].trim());
        if (parts.length > 3) provinceField.setText(parts[3].trim());
        if (parts.length > 4) zipField.setText(parts[4].trim());

        add(new JLabel("Street:"));
        add(streetField);
        add(new JLabel("Barangay:"));
        add(barangayField);
        add(new JLabel("City:"));
        add(cityField);
        add(new JLabel("Province:"));
        add(provinceField);
        add(new JLabel("Zip:"));
        add(zipField);

        JButton confirmButton = new JButton("Confirm");
        JButton cancelButton = new JButton("Cancel");

        add(confirmButton);
        add(cancelButton);

        confirmButton.addActionListener(e -> {
            confirmed = true;
            setVisible(false);
        });
        cancelButton.addActionListener(e -> {
            confirmed = false;
            setVisible(false);
        });

        pack();
        setLocationRelativeTo(parent);
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public String getAddress() {
        // Combine fields into one string
        return String.format("%s; %s; %s; %s; %s",
            streetField.getText().trim(),
            barangayField.getText().trim(),
            cityField.getText().trim(),
            provinceField.getText().trim(),
            zipField.getText().trim());
    }
}
