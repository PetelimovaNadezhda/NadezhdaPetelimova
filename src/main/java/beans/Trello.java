
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Trello {

    @SerializedName("board")
    @Expose
    public Integer board;
    @SerializedName("card")
    @Expose
    public Integer card;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("board", board).append("card", card).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(board).append(card).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Trello) == false) {
            return false;
        }
        Trello rhs = ((Trello) other);
        return new EqualsBuilder().append(board, rhs.board).append(card, rhs.card).isEquals();
    }

}
