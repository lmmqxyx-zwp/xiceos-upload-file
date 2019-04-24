package top.by.xuf.entity;

// 字段
public class Cloumn {

    // 字段名
    private String colName;

    // 字段类型
    private String colType;

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public String getColType() {
        return colType;
    }

    public void setColType(String colType) {
        this.colType = colType;
    }

    @Override
    public String toString() {
        return "Cloumn{" +
                "colName='" + colName + '\'' +
                ", colType='" + colType + '\'' +
                '}';
    }
}
