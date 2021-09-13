
import com.google.gson.annotations.SerializedName

data class RedditResponse(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("kind")
    val kind: String
)