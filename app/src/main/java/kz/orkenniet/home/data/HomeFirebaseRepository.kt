package kz.orkenniet.home.data

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kz.orkenniet.core.resource.Resource
import kz.orkenniet.home.domain.repository.HomeRepository
import kz.orkenniet.home.presentation.model.ListItem

class HomeFirebaseRepository(
    private val firebaseDatabase: FirebaseDatabase
) : HomeRepository {

    override fun getSortedBook(genre: String, result: (Resource<List<ListItem>>) -> Unit) {
        firebaseDatabase.reference.child("books").addValueEventListener(
            object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    result.invoke(
                        Resource.Success(emptyList())
                    )
                }

                override fun onCancelled(error: DatabaseError) {
                    result.invoke(
                        Resource.Error(error.message)
                    )
                }
            }
        )
    }
}