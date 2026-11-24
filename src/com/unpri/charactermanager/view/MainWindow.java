package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.util.ArrayList;

public class MainWindow extends JFrame {

    public MainWindow(ArrayList<Character> characters) {
        super("Character Manager");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null);

        String[] columns = {"ID", "Name", "Type", "Level", "HP", "Attack", "Mana", "Alive"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (Character character : characters) {
            tableModel.addRow(new Object[]{
                character.getId(),
                character.getName(),
                character.getType(),
                character.getLevel(),
                character.getHitPoints(),
                character.getAttackPower(),
                character.getMana(),
                character.isAlive()
            });
        }

        JTable characterTable = new JTable(tableModel);
        characterTable.setFillsViewportHeight(true);

        add(new JScrollPane(characterTable), BorderLayout.CENTER);
    }
}
