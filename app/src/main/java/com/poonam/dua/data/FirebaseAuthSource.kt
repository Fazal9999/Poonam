package com.poonam.dua.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.poonam.dua.utils.Config
import io.reactivex.Completable
import javax.inject.Inject


class FirebaseAuthSource @Inject constructor(
    var firebaseAuth: FirebaseAuth,
    var firebaseFirestore: FirebaseFirestore
) {
    //get current user uid
    val currentUid: String
        get() = firebaseAuth.currentUser!!.uid

    //get current user
    val currentUser: FirebaseUser?
        get() = firebaseAuth.currentUser

    //create new account
    fun register(email: String, password: String?, name: String): Completable {
        return Completable.create { emitter ->
            firebaseAuth.createUserWithEmailAndPassword(email, password!!)
                .addOnFailureListener { e -> emitter.onError(e) }
                .addOnCompleteListener { //create new user
                    val map: HashMap<String, Any> = HashMap()
                    map["email"] = email
                    map["displayName"] = name
                    map["image"] = "default"
                    map["status"] = "default"
                    map["online"] = true
                    firebaseFirestore.collection(Config.USER_NODE)
                        .document(currentUid).set(map)
                        .addOnFailureListener { e -> emitter.onError(e) }
                        .addOnSuccessListener { emitter.onComplete() }
                }
        }
    }

    //login
    fun login(email: String?, password: String?): Completable {
        return Completable.create { emitter ->
            firebaseAuth.signInWithEmailAndPassword(email!!, password!!)
                .addOnFailureListener { e -> emitter.onError(e) }
                .addOnSuccessListener { emitter.onComplete() }
        }
    }

    //logout
    fun logout() {
        firebaseAuth.signOut()
    }

    companion object {
        private const val TAG = "FirebaseAuthSource"
    }
}