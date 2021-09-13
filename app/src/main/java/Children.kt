
import com.google.gson.annotations.SerializedName
import com.kl3jvi.iquiitask.model.entities.ChildrenData

data class Children(
    @SerializedName("data")
    val `data`: ChildrenData,
    @SerializedName("kind")
    val kind: String
)