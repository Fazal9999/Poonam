package com.poonam.dua.data

import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.WriteBatch;
import com.google.firebase.firestore.auth.User
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.poonam.dua.utils.Config


import java.sql.Timestamp;
import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.functions.Cancellable;


class FirebaseDataSource {
    private val TAG = "FirebaseDataSource"

    private var firebaseAuthSource: FirebaseAuthSource? = null
    private var firebaseFirestore: FirebaseFirestore? = null
    private var storageReference: StorageReference? = null
    private var currentUid: String? = null

    @Inject
    constructor(
         firebaseAuthSource: FirebaseAuthSource,
        firebaseFirestore: FirebaseFirestore?,
        storageReference: StorageReference?
    ) {
        this.firebaseAuthSource = firebaseAuthSource
        this.firebaseFirestore = firebaseFirestore
        this.storageReference = storageReference
        currentUid = firebaseAuthSource.currentUid
    }

    //fireStore users list
    private fun getUsersQuery(): Query {
        return firebaseFirestore!!.collection(Config.USER_NODE)
    }

//    fun getUserList(): FirestoreRecyclerOptions<User?>? {
//        return Builder<User>()
//            .setQuery(getUsersQuery(), User::class.java)
//            .build()
//    }

    //fireStore request list
//    private fun getRequestQuery(): Query? {
//        return firebaseFirestore!!.collection(Constants.FRIEND_REQUEST_NODE)
//            .document(currentUid!!)
//            .collection(Constants.REQUEST_NODE)
//            .whereEqualTo("requestType", "received")
//    }
//
//    fun getRequestList(): FirestoreRecyclerOptions<Request?>? {
//        return Builder<Request>()
//            .setQuery(getRequestQuery(), Request::class.java)
//            .build()
//    }

    //fireStore friend list
//    private fun getFriendQuery(): Query? {
//        return firebaseFirestore!!.collection(Constants.FRIEND_REQUEST_NODE)
//            .document(currentUid!!)
//            .collection(Constants.REQUEST_NODE)
//            .whereEqualTo("requestType", "friend")
//    }
//
//    fun getFriendList(): FirestoreRecyclerOptions<Request?>? {
//        return Builder<Request>()
//            .setQuery(getFriendQuery(), Request::class.java)
//            .build()
//    }

    //get chat list
//    private fun getChatListQuery(uid: String): Query? {
//        return firebaseFirestore!!.collection(Constants.MESSAGE_NODE).document(currentUid!!)
//            .collection(uid)
//    }
//
//    fun getChatList(uid: String): FirestoreRecyclerOptions<Message?>? {
//        return Builder<Message>()
//            .setQuery(getChatListQuery(uid), Message::class.java)
//            .build()
//    }

    //get user information
//    fun getUserInfo(uid: String?): Flowable<DocumentSnapshot?>? {
//        return Flowable.create({ emitter ->
//            val reference = firebaseFirestore!!.collection(Constants.USERS_NODE).document(
//                uid!!
//            )
//            val registration =
//                reference.addSnapshotListener(object : EventListener<DocumentSnapshot?>() {
//                    fun onEvent(
//                        @Nullable documentSnapshot: DocumentSnapshot?,
//                        @Nullable e: FirebaseFirestoreException?
//                    ) {
//                        if (e != null) {
//                            emitter.onError(e)
//                        }
//                        if (documentSnapshot != null) {
//                            emitter.onNext(documentSnapshot)
//                        }
//                    }
//                })
//            emitter.setCancellable(object : Cancellable() {
//                @Throws(Exception::class)
//                fun cancel() {
//                    registration.remove()
//                }
//            })
//        }, BackpressureStrategy.BUFFER)
//    }

    //update status
    fun updateStatus(status: String?): Completable{
        return Completable.create { emitter ->
            val reference = firebaseFirestore!!.collection(com.poonam.dua.utils.Config.USER_NODE).document(
                currentUid!!
            )
            reference.update("status", status)
                .addOnFailureListener { e -> emitter.onError(e) }
                .addOnSuccessListener { emitter.onComplete() }
        }
    }

    //update displayImage
//    fun updateDisplayImage(bitmap: Bitmap?): Completable? {
//        return Completable.create { emitter ->
//            val reference = storageReference!!.child(Constants.PROFILE_IMAGE_NODE).child(
//                "$currentUid.jpg"
//            )
//            val db_reference = firebaseFirestore!!.collection(Constants.USERS_NODE).document(
//                currentUid!!
//            )
//            reference.putBytes(DataConverter.convertImage2ByteArray(bitmap))
//                .addOnFailureListener { e -> emitter.onError(e) }
//                .addOnSuccessListener { //get image download url;
//                    reference.downloadUrl.addOnFailureListener { e -> emitter.onError(e) }
//                        .addOnCompleteListener(
//                            OnCompleteListener<Any?> { task ->
//                                if (!task.isSuccessful) {
//                                    emitter.onError(task.getException())
//                                } else {
//                                    db_reference.update("image", task.result.toString())
//                                        .addOnFailureListener { e -> emitter.onError(e) }
//                                        .addOnSuccessListener { emitter.onComplete() }
//                                }
//                            })
//                }
//        }
//    }
//
//    //Send friend request
//    fun sendFriendRequest(req_uid: String?): Completable? {
//        return Completable.create { emitter -> //get time stamp
//            val timestamp = Timestamp(System.currentTimeMillis())
//            val requestBatch: WriteBatch = firebaseFirestore!!.batch()
//            val receiver_reference =
//                firebaseFirestore!!.collection(Constants.FRIEND_REQUEST_NODE).document(
//                    currentUid!!
//                ).collection(Constants.REQUEST_NODE).document(req_uid!!)
//            val sender_reference =
//                firebaseFirestore!!.collection(Constants.FRIEND_REQUEST_NODE).document(
//                    req_uid
//                ).collection(Constants.REQUEST_NODE).document(currentUid!!)
//            val receiver = Request("received", java.lang.String.valueOf(timestamp.getTime()))
//            val sender = Request("sender", java.lang.String.valueOf(timestamp.getTime()))
//            requestBatch.set(receiver_reference, sender)
//            requestBatch.set(sender_reference, receiver)
//            requestBatch.commit()
//                .addOnFailureListener(OnFailureListener { e -> emitter.onError(e) })
//                .addOnSuccessListener(OnSuccessListener<Void?> { emitter.onComplete() })
//        }
//    }
//
//    //Cancel friend request
//    fun cancelFriendRequest(req_uid: String?): Completable? {
//        return Completable.create { emitter ->
//            val requestBatch: WriteBatch = firebaseFirestore!!.batch()
//            val receiver_reference =
//                firebaseFirestore!!.collection(Constants.FRIEND_REQUEST_NODE).document(
//                    currentUid!!
//                ).collection(Constants.REQUEST_NODE).document(req_uid!!)
//            val sender_reference =
//                firebaseFirestore!!.collection(Constants.FRIEND_REQUEST_NODE).document(
//                    req_uid
//                ).collection(Constants.REQUEST_NODE).document(currentUid!!)
//            requestBatch.delete(receiver_reference)
//            requestBatch.delete(sender_reference)
//            requestBatch.commit()
//                .addOnFailureListener(OnFailureListener { e -> emitter.onError(e) })
//                .addOnSuccessListener(OnSuccessListener<Void?> { emitter.onComplete() })
//        }
//    }
//
//    //Accept friend request
//    fun acceptFriendRequest(req_uid: String?): Completable? {
//        return Completable.create { emitter -> //get time stamp
//            val timestamp = Timestamp(System.currentTimeMillis())
//            val requestBatch: WriteBatch = firebaseFirestore!!.batch()
//            val receiver_reference =
//                firebaseFirestore!!.collection(Constants.FRIEND_REQUEST_NODE).document(
//                    currentUid!!
//                ).collection(Constants.REQUEST_NODE).document(req_uid!!)
//            val sender_reference =
//                firebaseFirestore!!.collection(Constants.FRIEND_REQUEST_NODE).document(
//                    req_uid
//                ).collection(Constants.REQUEST_NODE).document(currentUid!!)
//            val friendMap: HashMap<String, Any> = HashMap()
//            friendMap["requestType"] = "friend"
//            requestBatch.set(receiver_reference, friendMap)
//            requestBatch.set(sender_reference, friendMap)
//            requestBatch.commit()
//                .addOnFailureListener(OnFailureListener { e -> emitter.onError(e) })
//                .addOnSuccessListener(OnSuccessListener<Void?> { emitter.onComplete() })
//        }
//    }
//
//    //observe request state
//    fun requestState(uid: String?): Flowable<DocumentSnapshot?>? {
//        return Flowable.create({ emitter ->
//            val receiver_reference =
//                firebaseFirestore!!.collection(Constants.FRIEND_REQUEST_NODE).document(
//                    currentUid!!
//                ).collection(Constants.REQUEST_NODE).document(uid!!)
//            val registration =
//                receiver_reference.addSnapshotListener(object : EventListener<DocumentSnapshot?>() {
//                    fun onEvent(
//                        @Nullable documentSnapshot: DocumentSnapshot?,
//                        @Nullable e: FirebaseFirestoreException?
//                    ) {
//                        if (e != null) {
//                            emitter.onError(e)
//                        }
//                        emitter.onNext(documentSnapshot!!)
//                    }
//                })
//            emitter.setCancellable(object : Cancellable() {
//                @Throws(Exception::class)
//                fun cancel() {
//                    registration.remove()
//                }
//            })
//        }, BackpressureStrategy.BUFFER)
//    }
//
//    //Send message
//    fun sendMessage(friendUid: String?, message: Message): Completable? {
//        return Completable.create { emitter ->
//            val requestBatch: WriteBatch = firebaseFirestore!!.batch()
//            message.setSenderUid(firebaseAuthSource!!.currentUid)
//            val timestamp = Timestamp(System.currentTimeMillis())
//            val sender_reference = firebaseFirestore!!.collection(Constants.MESSAGE_NODE).document(
//                currentUid!!
//            ).collection(friendUid!!).document(timestamp.toString())
//            val receiver_reference =
//                firebaseFirestore!!.collection(Constants.MESSAGE_NODE).document(
//                    friendUid
//                ).collection(currentUid!!).document(timestamp.toString())
//            requestBatch.set(receiver_reference, message)
//            requestBatch.set(sender_reference, message)
//            requestBatch.commit()
//                .addOnFailureListener(OnFailureListener { e -> emitter.onError(e) })
//                .addOnSuccessListener(OnSuccessListener<Void?> { emitter.onComplete() })
//        }
//    }
//
//    //get user information
//    fun getFriendInfo(uid: String?): Single<User?>? {
//        return Single.create(SingleOnSubscribe<Any?> { emitter ->
//            val reference = firebaseFirestore!!.collection(Constants.USERS_NODE).document(
//                uid!!
//            )
//            val registration =
//                reference.addSnapshotListener(object : EventListener<DocumentSnapshot?>() {
//                    fun onEvent(
//                        @Nullable documentSnapshot: DocumentSnapshot?,
//                        @Nullable e: FirebaseFirestoreException?
//                    ) {
//                        if (e != null) {
//                            emitter.onError(e)
//                        }
//                        if (documentSnapshot != null) {
//                            val user: User = documentSnapshot.toObject(User::class.java)
//                            emitter.onSuccess(user)
//                        }
//                    }
//                })
//        })
//    }
//
//    //get message
//    fun getMessageList(uid: String?): Flowable<QuerySnapshot?>? {
//        return Flowable.create({ emitter ->
//            val reference = firebaseFirestore!!.collection(Constants.MESSAGE_NODE).document(
//                currentUid!!
//            ).collection(uid!!)
//            val registration =
//                reference.addSnapshotListener(object : EventListener<QuerySnapshot?>() {
//                    fun onEvent(
//                        @Nullable queryDocumentSnapshots: QuerySnapshot?,
//                        @Nullable e: FirebaseFirestoreException?
//                    ) {
//                        if (e != null) {
//                            emitter.onError(e)
//                        }
//                        if (queryDocumentSnapshots != null) {
//                            emitter.onNext(queryDocumentSnapshots)
//                        }
//                    }
//                })
//            emitter.setCancellable(object : Cancellable() {
//                @Throws(Exception::class)
//                fun cancel() {
//                    registration.remove()
//                }
//            })
//        }, BackpressureStrategy.BUFFER)
//    }
}