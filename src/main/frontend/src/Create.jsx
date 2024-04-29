import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import createBlogURL from './Services/createBlogURL';
import { useAllowed } from './util/useAllowed';
import Loading from './Loading';
import { useAuth0 } from '@auth0/auth0-react';

const Create = () => {
    //Prevent unauthorized users from accessing the create page
    const { isAllowed } = useAllowed();
    const navigate = useNavigate();

    if (!isAllowed) {
        navigate('/');
    }

    const {user, isAuthenticated} = useAuth0();

    const [title, setTitle] = useState('');
    const [author, setAuthor] = useState(user.name);
    const [address, setAddress] = useState('');
    const [city, setCity] = useState('');
    const [hours, setHours] = useState('');
    const [phone, setPhone] = useState(user.phone_number);
    const [email, setEmail] = useState(user.email);
    const [body, setBody] = useState('');
    const [isLoading, setIsLoading] = useState(false);
    
    if(isLoading){
        return <Loading />
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        const blog = { title, author, address, city, hours, phone, email, body };

        setIsLoading(true);

        fetch(createBlogURL(), {
            method: 'POST',
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(blog)
        }).then(() => {
            console.log('new blog added');
            setIsLoading(false);
            navigate('/');
        })
    }

    return (
        <div className="create">
            <h2>Add a new blog</h2>
            <p>Author: {author}</p>
            <p>Email: {email}</p>
            <form onSubmit={handleSubmit}>
                <label>Blog title:</label>
                <input
                    type="text"
                    required
                    value={title}
                    onChange={(e) => setTitle(e.target.value)}
                />
                {/* <label>Author:</label>
                <input
                    type="text"
                    required
                    value={author}
                    readOnly
                    onChange={(e) => setAuthor(e.target.value)}
                /> */}
                <label>Address:</label>
                <input
                    type="text"
                    required
                    value={address}
                    onChange={(e) => setAddress(e.target.value)}
                />
                <label>City:</label>
                <input
                    type="text"
                    required
                    value={city}
                    onChange={(e) => setCity(e.target.value)}
                />
                <label>Hours:</label>
                <input
                    type="text"
                    required
                    value={hours}
                    onChange={(e) => setHours(e.target.value)}
                />
                <label>Phone:</label>
                <label > Ex : 9999999999, 999-999-9999 </label> 
                <input
                    type="number"
                    required
                    pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}"
                    value={phone}
                    onChange={(e) => setPhone(e.target.value)}
                />
                {/* <label>Email:</label>
                <input
                    type="text"
                    required
                    value={email}
                    readOnly
                    onChange={(e) => setEmail(e.target.value)}
                /> */}
                <label>Blog body:</label>
                <textarea
                    required
                    value={body}
                    onChange={(e) => setBody(e.target.value)}
                ></textarea>
                {!isLoading && <button>Add Blog</button>}
                {isLoading && <button disabled>Adding Blog...</button>}
            </form>
        </div>
    );
}

export default Create;