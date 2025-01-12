package data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

class FirestoreRepository(private val db: FirebaseFirestore) {

    fun addUser(
        email: String,
        password: String,
        username: String,
        onSuccess: () -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        val user = hashMapOf(
            "email" to email,
            "password" to password,
            "username" to username // Adăugăm și username-ul
        )

        db.collection("users")
            .add(user)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { onFailure(it) }
    }
    fun getUsers(onSuccess: (QuerySnapshot) -> Unit, onFailure: (Exception) -> Unit) {
        db.collection("users")
            .get()
            .addOnSuccessListener { onSuccess(it) }
            .addOnFailureListener { onFailure(it) }
    }
    fun verifyUser(
        email: String,
        password: String,
        onSuccess: (Boolean) -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        db.collection("users")
            .whereEqualTo("email", email)
            .whereEqualTo("password", password)
            .get()
            .addOnSuccessListener { result ->
                onSuccess(!result.isEmpty) // Dacă există documente, utilizatorul este valid
            }
            .addOnFailureListener { exception ->
                onFailure(exception)
            }
    }
        fun updateUserPassword(
            email: String,
            newPassword: String,
            onSuccess: () -> Unit,
            onFailure: (Exception) -> Unit
        ) {
            db.collection("users")
                .whereEqualTo("email", email)
                .get()
                .addOnSuccessListener { querySnapshot ->
                    if (!querySnapshot.isEmpty) {
                        val document = querySnapshot.documents[0]
                        document.reference.update("password", newPassword)
                            .addOnSuccessListener { onSuccess() }
                            .addOnFailureListener { exception -> onFailure(exception) }
                    } else {
                        onFailure(Exception("No user found with this email"))
                    }
                }
                .addOnFailureListener { exception -> onFailure(exception) }
        }
}
