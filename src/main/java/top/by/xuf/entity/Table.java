package top.by.xuf.entity;

import java.util.List;

// 表
public class Table {

    // 表名
    private String tableName;

    // 字段
    private List<Cloumn> cloumns;

    // 数据
    private Object data;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<Cloumn> getCloumns() {
        return cloumns;
    }

    public void setCloumns(List<Cloumn> cloumns) {
        this.cloumns = cloumns;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Table{" +
                "tableName='" + tableName + '\'' +
                ", cloumns=" + cloumns +
                ", data=" + data +
                '}';
    }
}
