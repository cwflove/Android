package git.example.dell.serializableimp;

import java.io.Serializable;

/**
 * @author 陈伟飞
 * @date 2019/4/17.
 * @function  序列化：内存中对象-->磁盘
 *             反列化：磁盘中对象-->内存
 */
public class SerializableImplementImpl implements Serializable {

    /**
     * 生成序列号标识
     * File-->settings-->inspections-->Serializable class without 'serialVersionUID'
     */
    private static final long serialVersionUID = -7922115673957847636L;

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
