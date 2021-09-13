
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("after")
    val after: Any,
    @SerializedName("before")
    val before: Any,
    @SerializedName("children")
    val children: List<Children>,
    @SerializedName("dist")
    val dist: Int,
    @SerializedName("geo_filter")
    val geoFilter: String,
    @SerializedName("modhash")
    val modhash: String
)