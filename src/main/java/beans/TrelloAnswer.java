
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class TrelloAnswer {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("desc")
    @Expose
    public String desc;
    @SerializedName("descData")
    @Expose
    public Object descData;
    @SerializedName("closed")
    @Expose
    public Boolean closed;
    @SerializedName("idOrganization")
    @Expose
    public Object idOrganization;
    @SerializedName("pinned")
    @Expose
    public Boolean pinned;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("shortUrl")
    @Expose
    public String shortUrl;
    @SerializedName("prefs")
    @Expose
    public Prefs prefs;
    @SerializedName("labelNames")
    @Expose
    public LabelNames labelNames;
    @SerializedName("limits")
    @Expose
    public Limits limits;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("desc", desc).append("descData", descData).append("closed", closed).append("idOrganization", idOrganization).append("pinned", pinned).append("url", url).append("shortUrl", shortUrl).append("prefs", prefs).append("labelNames", labelNames).append("limits", limits).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(descData).append(pinned).append(labelNames).append(shortUrl).append(url).append(prefs).append(name).append(idOrganization).append(closed).append(id).append(limits).append(desc).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TrelloAnswer) == false) {
            return false;
        }
        TrelloAnswer rhs = ((TrelloAnswer) other);
        return new EqualsBuilder().append(descData, rhs.descData).append(pinned, rhs.pinned).append(labelNames, rhs.labelNames).append(shortUrl, rhs.shortUrl).append(url, rhs.url).append(prefs, rhs.prefs).append(name, rhs.name).append(idOrganization, rhs.idOrganization).append(closed, rhs.closed).append(id, rhs.id).append(limits, rhs.limits).append(desc, rhs.desc).isEquals();
    }

}
