import { Link } from "react-router-dom";
import { useNavigate } from 'react-router-dom';
import deactivateURL from "./Services/deactivateURL";
import activateURL from "./Services/activateURL";

const MyBlogList = ({blogs}) => {
    
    const navigate = useNavigate();

    const handleActiveBlog = (id) => {
        
        fetch(activateURL(id), {
            method: 'DELETE',
            headers: { "Content-Type": "application/json" },
        }).then(() => {
            console.log(`blog ${id} activated`);
            navigate('/');
        })
    };

    const handleInactiveBlog = (id) => {

        fetch(deactivateURL(id), {
            method: 'DELETE',
            headers: { "Content-Type": "application/json" },
        }).then(() => {
            console.log(`blog ${id} deactivated`);
            navigate('/');
        })
    };

    return ( 
        <div className="blog-list"> 
            {blogs.map(blog => (
                <div className="my-blog-preview" key={blog.id}>

                        <h2>{blog.title}</h2>
                        <p>{blog.city}</p>
                        {blog.active === 'A' ? (
                            <button onClick={() => handleInactiveBlog(blog.id)}>
                                Close Event
                            </button>
                        ) : (
                            <button onClick={() => handleActiveBlog(blog.id)}>
                                Re-Open Event
                            </button>
                        )}

                </div>
            ))}
        </div>
     );
}
 
export default MyBlogList;