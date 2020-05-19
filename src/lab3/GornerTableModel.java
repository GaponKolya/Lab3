package lab3;

import javax.swing.table.AbstractTableModel;
@SuppressWarnings("serial")
public class GornerTableModel extends AbstractTableModel {
    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;
    private double result[] = new double[3];

    public GornerTableModel(Double from, Double to, Double step,

                            Double[] coefficients) {

        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }

    public Double getFrom() {
        return from;
    }

    public Double getTo() {
        return to;
    }

    public Double getStep() {
        return step;
    }

    public int getColumnCount() {
// В данной модели два столбца
        return 3;
    }

    public int getRowCount() {
// Вычислить количество точек между началом и концом отрезка
// исходя из шага табулирования
        return new Double(Math.ceil((to - from) / step)).intValue() + 1;
    }

    public Object getValueAt(int row, int col) {

// Вычислить значение X как НАЧАЛО_ОТРЕЗКА + ШАГ*НОМЕР_СТРОКИ
        double x = from + step * row;
        switch (col) {
            case 0:
// Если запрашивается значение 1-го столбца, то это X
                return x;
            case 1:
                return x * coefficients[0];
            default:
                x = Math.sqrt(x*coefficients[0]);
                if (x == (int) x) {
                    return true;
                } else {
                    return false;
                }
        }
    }

    public String getColumnName(int col) {
        switch (col) {
            case 0:
// Название 1-го столбца
                return "Значение X";
            case 1:
// Название 2-го столбца
                return "Значение многочлена";
            default:
                return "Целая часть является квадратом?";
        }
    }

    public Class<?> getColumnClass(int col) {
        switch (col) {
            case 0:
                return Double.class;
            case 1:
                return Double.class;
            default:
                return Boolean.class;
        }
    }
}