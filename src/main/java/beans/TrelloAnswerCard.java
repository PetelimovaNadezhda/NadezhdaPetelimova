
package beans;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class TrelloAnswerCard {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("checkItemStates")
    @Expose
    public Object checkItemStates;
    @SerializedName("closed")
    @Expose
    public Boolean closed;
    @SerializedName("dateLastActivity")
    @Expose
    public String dateLastActivity;
    @SerializedName("desc")
    @Expose
    public String desc;
    @SerializedName("descData")
    @Expose
    public Object descData;
    @SerializedName("dueReminder")
    @Expose
    public Object dueReminder;
    @SerializedName("idBoard")
    @Expose
    public String idBoard;
    @SerializedName("idList")
    @Expose
    public String idList;
    @SerializedName("idMembersVoted")
    @Expose
    public List<Object> idMembersVoted = new ArrayList<Object>();
    @SerializedName("idShort")
    @Expose
    public Integer idShort;
    @SerializedName("idAttachmentCover")
    @Expose
    public Object idAttachmentCover;
    @SerializedName("idLabels")
    @Expose
    public List<Object> idLabels = new ArrayList<Object>();
    @SerializedName("manualCoverAttachment")
    @Expose
    public Boolean manualCoverAttachment;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("pos")
    @Expose
    public Integer pos;
    @SerializedName("shortLink")
    @Expose
    public String shortLink;
    @SerializedName("badges")
    @Expose
    public Badges badges;
    @SerializedName("dueComplete")
    @Expose
    public Boolean dueComplete;
    @SerializedName("due")
    @Expose
    public Object due;
    @SerializedName("idChecklists")
    @Expose
    public List<Object> idChecklists = new ArrayList<Object>();
    @SerializedName("idMembers")
    @Expose
    public List<Object> idMembers = new ArrayList<Object>();
    @SerializedName("labels")
    @Expose
    public List<Object> labels = new ArrayList<Object>();
    @SerializedName("shortUrl")
    @Expose
    public String shortUrl;
    @SerializedName("subscribed")
    @Expose
    public Boolean subscribed;
    @SerializedName("url")
    @Expose
    public String url;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("checkItemStates", checkItemStates).append("closed", closed).append("dateLastActivity", dateLastActivity).append("desc", desc).append("descData", descData).append("dueReminder", dueReminder).append("idBoard", idBoard).append("idList", idList).append("idMembersVoted", idMembersVoted).append("idShort", idShort).append("idAttachmentCover", idAttachmentCover).append("idLabels", idLabels).append("manualCoverAttachment", manualCoverAttachment).append("name", name).append("pos", pos).append("shortLink", shortLink).append("badges", badges).append("dueComplete", dueComplete).append("due", due).append("idChecklists", idChecklists).append("idMembers", idMembers).append("labels", labels).append("shortUrl", shortUrl).append("subscribed", subscribed).append("url", url).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(descData).append(idLabels).append(shortUrl).append(dueComplete).append(dateLastActivity).append(idList).append(idMembersVoted).append(shortLink).append(dueReminder).append(subscribed).append(pos).append(idChecklists).append(id).append(idBoard).append(checkItemStates).append(url).append(labels).append(badges).append(idMembers).append(idShort).append(due).append(idAttachmentCover).append(name).append(closed).append(manualCoverAttachment).append(desc).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TrelloAnswerCard) == false) {
            return false;
        }
        TrelloAnswerCard rhs = ((TrelloAnswerCard) other);
        return new EqualsBuilder().append(descData, rhs.descData).append(idLabels, rhs.idLabels).append(shortUrl, rhs.shortUrl).append(dueComplete, rhs.dueComplete).append(dateLastActivity, rhs.dateLastActivity).append(idList, rhs.idList).append(idMembersVoted, rhs.idMembersVoted).append(shortLink, rhs.shortLink).append(dueReminder, rhs.dueReminder).append(subscribed, rhs.subscribed).append(pos, rhs.pos).append(idChecklists, rhs.idChecklists).append(id, rhs.id).append(idBoard, rhs.idBoard).append(checkItemStates, rhs.checkItemStates).append(url, rhs.url).append(labels, rhs.labels).append(badges, rhs.badges).append(idMembers, rhs.idMembers).append(idShort, rhs.idShort).append(due, rhs.due).append(idAttachmentCover, rhs.idAttachmentCover).append(name, rhs.name).append(closed, rhs.closed).append(manualCoverAttachment, rhs.manualCoverAttachment).append(desc, rhs.desc).isEquals();
    }

}
