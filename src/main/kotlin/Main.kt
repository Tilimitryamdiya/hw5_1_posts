data class Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int = 0,
    val createdBy: Int = 0,
    val date: Int,
    val text: String,
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val friendsOnly: Boolean = false,
    val comments: Comments = Comments(),
    val likes: Likes = Likes()
)

data class Comments(
    var count: Int = 0,
    var canPost: Boolean = true,
    var groupsCanPost: Boolean = false,
    var canClose: Boolean = false,
    var canOpen: Boolean = false
)

class Likes(
    count: Int = 0,
    var userLikes: Boolean = false,
    var canLike: Boolean = true,
    var canPublish: Boolean = false
) {
    var count: Int = count
        set(value) {
            if (value < 0) {
                return
            }
            field = value
        }
}

object WallService {
    private var posts = emptyArray<Post>()
    fun add(post: Post): Post{
        posts += post
        return posts.last()
    }
}


fun main() {
    val post1 = Post(
        id = 0,
        ownerId = 1, 2,
        date = 3,
        text = "post",
        friendsOnly = true,
        likes = Likes(count = 1)
    )

    val service = WallService
    service.add(post1)
}