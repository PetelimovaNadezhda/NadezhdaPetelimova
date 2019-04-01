
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class AttachmentsByType {

    @SerializedName("trello")
    @Expose
    public Trello trello;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("trello", trello).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(trello).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AttachmentsByType) == false) {
            return false;
        }
        AttachmentsByType rhs = ((AttachmentsByType) other);
        return new EqualsBuilder().append(trello, rhs.trello).isEquals();
    }

}
