
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class CheckItem {

    @SerializedName("state")
    @Expose
    public String state;
    @SerializedName("idChecklist")
    @Expose
    public String idChecklist;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("nameData")
    @Expose
    public Object nameData;
    @SerializedName("pos")
    @Expose
    public Integer pos;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("state", state).append("idChecklist", idChecklist).append("id", id).append("name", name).append("nameData", nameData).append("pos", pos).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(pos).append(idChecklist).append(name).append(nameData).append(state).append(id).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CheckItem) == false) {
            return false;
        }
        CheckItem rhs = ((CheckItem) other);
        return new EqualsBuilder().append(pos, rhs.pos).append(idChecklist, rhs.idChecklist).append(name, rhs.name).append(nameData, rhs.nameData).append(state, rhs.state).append(id, rhs.id).isEquals();
    }

}
