package views.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import play.data.validation.ValidationError;
import play.i18n.Messages;

public class ActorForm {

  public String id = "";
  public String name = "";
  public String height = "";
  public String blood = "";
  public String birthday = "";
  public String birthplaceId = "";

  public ActorForm() {
  }

  public ActorForm(String id, String name, String height, String blood,
      String birthday, String birthplaceId) {
    this.id = id;
    this.name = name;
    this.height = height;
    this.blood = blood;
    this.birthday = birthday;
    this.birthplaceId = birthplaceId;
  }


  public List<ValidationError> validate() {
    System.out.println("ActorForm#validate IN");
    List<ValidationError> errors = new ArrayList<ValidationError>();

    if (name == null || name.length() == 0) {
      errors.add(new ValidationError("name", Messages.get("actor.name.required")));
    }
    if (StringUtils.isNotEmpty(height)) {
      Integer tmpH = Integer.valueOf(height);
      if (tmpH < 1 && tmpH > 200) {
        errors.add(new ValidationError("height", Messages.get("actor.height.range", 1, 200)));
      }
    }
    if (StringUtils.isNotEmpty(blood) && !blood.matches("A|B|AB|O")) {
      errors.add(new ValidationError("blood", Messages.get("actor.blood.kind")));
    }

    if (StringUtils.isNotEmpty(birthday) && !birthday.matches("\\d{4}-\\d{2}-\\d{2}")) {
      errors.add(new ValidationError("birthday", Messages.get("actor.birthday.pattern")));
    }

    if (StringUtils.isNotEmpty(birthplaceId)) {
      Integer tmpB = Integer.valueOf(birthplaceId);
      if (tmpB < 1 && tmpB > 47) {
        errors.add(new ValidationError("birthplaceId", Messages.get("actor.birthplace.range")));
      }
    }

    if(errors.size() > 0) {
      System.out.println("ActorForm#validate errors");
      return errors;
    }

    System.out.println("ActorForm#validate OUT");

    return null;
  }


  @Override
  public String toString() {
    return "ActorForm [id=" + id + ", name=" + name + ", height=" + height
        + ", blood=" + blood + ", birthday=" + birthday + ", birthplaceId="
        + birthplaceId + "]";
  }

}
