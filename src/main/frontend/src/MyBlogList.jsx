import { Link } from "react-router-dom";

const MyBlogList = ({blogs}) => {
    
    return ( 
        <div className="blog-list"> 
            {blogs.map(blog => (
                <div className="my-blog-preview" key={blog.id}>
                    <Link to={`/blogs/${blog.id}`}>
                        <h2>{blog.title}</h2>
                        <p>{blog.author}</p>
                        <p>{blog.city}</p>
                    </Link>
                </div>
            ))}
        </div>
     );
}
 
export default MyBlogList;