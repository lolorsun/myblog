package com.lolorsun.myblog.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author lolorsun
 * @Date 2022/2/20 20:13
 * @Version 1.0
 */
@Entity
@Table(name = "t_type   ")
public class Type {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToMany(mappedBy = "type")
    private List<Blog> blogs = new ArrayList<>();
    public Type() {
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
