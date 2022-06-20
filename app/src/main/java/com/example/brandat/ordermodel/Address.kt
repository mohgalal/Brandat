package com.example.brandat.models.orderModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Address(
    @SerializedName( "first_name")
    val firstName: String? = "",
    @SerializedName( "last_name")
    val lastName: String? = "",
    @SerializedName( "address2")
    val address: String? = "",
    @SerializedName( "city")
    val city: String? = "",
    @SerializedName( "country")
    val country: String? = "",
    @SerializedName( "phone")
    val phone: String? = "",
    @SerializedName("address1")
    val address1: String? = "",
    @SerializedName("latitude")
    var latitude: String? = "",
    @SerializedName("longitude")
    var longitude: String? = "",

    ) : Parcelable