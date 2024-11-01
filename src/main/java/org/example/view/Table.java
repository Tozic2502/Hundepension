package org.example.view;

public class Table {
    int colums = 0;
    int rows = 0;
    int columSize = 0;
    String borderCharHorizontal = "";
    String borderCharVertical = "";
    String[][] content = null;
    String[] columNames = null;
    boolean showRowNumber = true;

    public Table(int rows, int colums, String borderCharHorizontal, String borderCharVertical, int columSize) {
        this.rows = rows;
        this.colums = colums;
        this.borderCharHorizontal = borderCharHorizontal;
        this.borderCharVertical = borderCharVertical;
        content = new String[rows][colums];
        this.columSize = columSize;


    }
    public Table(String[] columNames, String[][] content) {
        this.columNames = columNames;
        this.content = content;
    }
    public void put(String[][] input) {
        content = input;
    }
    public void setColumNames(String[] columNames) {
        this.columNames = columNames;
    }
    public void write(int x, int y, String value) {
        if (x < content.length && y < content[x].length) {
            content[x][y] = value;
        }
    }
    public String get(int x, int y) {
        return content[x][y];
    }
    public void print() {
        if (showRowNumber) {
            System.out.println(" " + borderCharHorizontal.repeat(columSize * colums + 3));
        } else {
            System.out.println(" " + borderCharHorizontal.repeat(columSize * colums));
        }
        if (showRowNumber) {
            System.out.printf(borderCharVertical + " ".repeat(3));
        }
        for (int i = 0; i < colums; i++) {
            System.out.printf(borderCharVertical + columNames[i] + " ".repeat(columSize - columNames[i].length()));

        }
        System.out.printf(borderCharVertical + "\n");
        if (showRowNumber) {
            System.out.println(" " + borderCharHorizontal.repeat(columSize * colums + 3));
        } else {
            System.out.println(" " + borderCharHorizontal.repeat(columSize * colums));
        }

        for (int i = 0; i < rows; i++) {

            if (showRowNumber) {
                System.out.printf(borderCharVertical + i + " ".repeat(3 - String.valueOf(i).length()));
            }
            for (int j = 0; j < colums; j++) {
                System.out.printf(borderCharVertical + content[i][j] + " ".repeat(columSize - content[i][j].length()));
            }
            System.out.printf(borderCharVertical + "\n");
            if (showRowNumber) {
                System.out.println(" " + borderCharHorizontal.repeat(columSize * colums + 3));
            } else {
                System.out.println(" " + borderCharHorizontal.repeat(columSize * colums));
            }
        }
    }
}
