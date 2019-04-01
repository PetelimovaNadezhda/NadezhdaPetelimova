
package beans;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class TrelloAnswerChecklist {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("idBoard")
    @Expose
    public String idBoard;
    @SerializedName("idCard")
    @Expose
    public String idCard;
    @SerializedName("pos")
    @Expose
    public Integer pos;
    @SerializedName("checkItems")
    @Expose
    public List<CheckItem> checkItems = new ArrayList<CheckItem>();

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("idBoard", idBoard).append("idCard", idCard).append("pos", pos).append("checkItems", checkItems).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(idBoard).append(pos).append(idCard).append(name).append(id).append(checkItems).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TrelloAnswerChecklist) == false) {
            return false;
        }
        TrelloAnswerChecklist rhs = ((TrelloAnswerChecklist) other);
        return new EqualsBuilder().append(idBoard, rhs.idBoard).append(pos, rhs.pos).append(idCard, rhs.idCard).append(name, rhs.name).append(id, rhs.id).append(checkItems, rhs.checkItems).isEquals();
    }

}
