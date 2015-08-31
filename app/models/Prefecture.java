package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.avaje.ebean.Model;

@Entity(name = "prefecture")
public class Prefecture extends Model {

  @Id
  @Min(1)
  @Max(2)
  public Integer id;
  @NotNull
  @Size(min = 1, max = 6)
  public String name;

  public Prefecture() {
  }

  public Prefecture(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public static List<Prefecture> list() {
    return Prefecture.finder.order("id").findList();
  }

  public static Finder<Long, Prefecture> finder = new Finder<Long, Prefecture>(Prefecture.class);

  @Override
  public String toString() {
    return "Prefecture [id=" + id + ", name=" + name + "]";
  }

}