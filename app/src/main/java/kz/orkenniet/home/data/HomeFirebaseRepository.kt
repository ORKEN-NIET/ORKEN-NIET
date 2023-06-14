package kz.orkenniet.home.data

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue
import kz.orkenniet.core.resource.Resource
import kz.orkenniet.home.domain.repository.HomeRepository
import kz.orkenniet.home.presentation.model.Book
import kz.orkenniet.home.presentation.model.ListItem

class HomeFirebaseRepository(
    private val firebaseDatabase: FirebaseDatabase
) : HomeRepository {

    override fun getSortedBook(genre: String, result: (Resource<List<ListItem>>) -> Unit) {
        firebaseDatabase.reference.child("Books").addValueEventListener(
            object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    Log.v("qwer", "${snapshot.value}")
                    val booklist = snapshot.getValue<HashMap<String, Book>>()
                        ?.map { it.value }
                        .orEmpty()

                    val sortedList = booklist.filter { it.Genre == genre }

                    result.invoke(Resource.Success(sortedList))
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.d("qwer", error.message)
                    result.invoke(
                        Resource.Error(error.message)
                    )
                }
            }
        )
    }
}
