
package beans;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class TrelloAnswerList {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("cards")
    @Expose
    public List<Card> cards = new ArrayList<Card>();

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("cards", cards).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(id).append(cards).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TrelloAnswerList) == false) {
            return false;
        }
        TrelloAnswerList rhs = ((TrelloAnswerList) other);
        return new EqualsBuilder().append(name, rhs.name).append(id, rhs.id).append(cards, rhs.cards).isEquals();
    }

}
