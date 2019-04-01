
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Badges {

    @SerializedName("attachmentsByType")
    @Expose
    public AttachmentsByType attachmentsByType;
    @SerializedName("location")
    @Expose
    public Boolean location;
    @SerializedName("votes")
    @Expose
    public Integer votes;
    @SerializedName("viewingMemberVoted")
    @Expose
    public Boolean viewingMemberVoted;
    @SerializedName("subscribed")
    @Expose
    public Boolean subscribed;
    @SerializedName("fogbugz")
    @Expose
    public String fogbugz;
    @SerializedName("checkItems")
    @Expose
    public Integer checkItems;
    @SerializedName("checkItemsChecked")
    @Expose
    public Integer checkItemsChecked;
    @SerializedName("comments")
    @Expose
    public Integer comments;
    @SerializedName("attachments")
    @Expose
    public Integer attachments;
    @SerializedName("description")
    @Expose
    public Boolean description;
    @SerializedName("due")
    @Expose
    public Object due;
    @SerializedName("dueComplete")
    @Expose
    public Boolean dueComplete;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("attachmentsByType", attachmentsByType).append("location", location).append("votes", votes).append("viewingMemberVoted", viewingMemberVoted).append("subscribed", subscribed).append("fogbugz", fogbugz).append("checkItems", checkItems).append("checkItemsChecked", checkItemsChecked).append("comments", comments).append("attachments", attachments).append("description", description).append("due", due).append("dueComplete", dueComplete).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(comments).append(attachments).append(attachmentsByType).append(dueComplete).append(description).append(subscribed).append(due).append(viewingMemberVoted).append(location).append(votes).append(fogbugz).append(checkItems).append(checkItemsChecked).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Badges) == false) {
            return false;
        }
        Badges rhs = ((Badges) other);
        return new EqualsBuilder().append(comments, rhs.comments).append(attachments, rhs.attachments).append(attachmentsByType, rhs.attachmentsByType).append(dueComplete, rhs.dueComplete).append(description, rhs.description).append(subscribed, rhs.subscribed).append(due, rhs.due).append(viewingMemberVoted, rhs.viewingMemberVoted).append(location, rhs.location).append(votes, rhs.votes).append(fogbugz, rhs.fogbugz).append(checkItems, rhs.checkItems).append(checkItemsChecked, rhs.checkItemsChecked).isEquals();
    }

}
