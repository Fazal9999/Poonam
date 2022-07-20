package com.poonam.dua.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
 data class UserInfo(
val name:String?=null,
val gender:String?=null,
val age:String?=null,
val units:String?=null,
val height:String?=null,
val weight:String?=null,
val goal:String?=null,
val dailyStepGoal:String?=null,
val dailyActivityLevel:String?=null,
val diet:String?=null

):Parcelable{
 override fun equals(other: Any?): Boolean {
  return super.equals(other)
 }

 override fun hashCode(): Int {
  return super.hashCode()
 }

 override fun toString(): String {
  return super.toString()
 }


}
