package com.kl3jvi.iquiitask.model.entities


import com.google.gson.annotations.SerializedName

data class AllAwarding(
    @SerializedName("award_sub_type")
    val awardSubType: String,
    @SerializedName("award_type")
    val awardType: String,
    @SerializedName("awardings_required_to_grant_benefits")
    val awardingsRequiredToGrantBenefits: Any,
    @SerializedName("coin_price")
    val coinPrice: Int,
    @SerializedName("coin_reward")
    val coinReward: Int,
    @SerializedName("count")
    val count: Int,
    @SerializedName("days_of_drip_extension")
    val daysOfDripExtension: Int,
    @SerializedName("days_of_premium")
    val daysOfPremium: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("end_date")
    val endDate: Any,
    @SerializedName("giver_coin_reward")
    val giverCoinReward: Any,
    @SerializedName("icon_format")
    val iconFormat: Any,
    @SerializedName("icon_height")
    val iconHeight: Int,
    @SerializedName("icon_url")
    val iconUrl: String,
    @SerializedName("icon_width")
    val iconWidth: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("is_enabled")
    val isEnabled: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("penny_donate")
    val pennyDonate: Any,
    @SerializedName("penny_price")
    val pennyPrice: Any,
    @SerializedName("resized_icons")
    val resizedIcons: List<ResizedIcon>,
    @SerializedName("resized_static_icons")
    val resizedStaticIcons: List<ResizedStaticIcon>,
    @SerializedName("start_date")
    val startDate: Any,
    @SerializedName("static_icon_height")
    val staticIconHeight: Int,
    @SerializedName("static_icon_url")
    val staticIconUrl: String,
    @SerializedName("static_icon_width")
    val staticIconWidth: Int,
    @SerializedName("subreddit_coin_reward")
    val subredditCoinReward: Int,
    @SerializedName("subreddit_id")
    val subredditId: Any,
    @SerializedName("tiers_by_required_awardings")
    val tiersByRequiredAwardings: Any
)