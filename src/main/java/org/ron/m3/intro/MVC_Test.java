package org.ron.m3.intro;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.*;

public class MVC_Test {

    public static void main(String[] args) {
        new MVC_Test().test();
    }

    private void test() {

        JTable table = new JTable(new MyTableModel());

        JScrollPane scrollPane = new JScrollPane(table);

        JFrame frame = new JFrame("MVC Test");
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(500, 800);
        frame.setVisible(true);
    }

    private class MyTableModel implements TableModel {

        // private List<MyStorageObject> list;

        @Override
        public int getRowCount() {
            return 1_000_000;
        }

        @Override
        public int getColumnCount() {
            return 10;
        }

        @Override
        public String getColumnName(int columnIndex) {
            return "Col " + columnIndex;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return String.class;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return "r=" + rowIndex + ", c=" + columnIndex;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        }

        @Override
        public void addTableModelListener(TableModelListener l) {

        }

        @Override
        public void removeTableModelListener(TableModelListener l) {

        }
    }

}
