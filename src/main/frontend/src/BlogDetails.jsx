import { useParams, useNavigate } from "react-router-dom";
import useFetch from "./useFetch";
import blogIDToURL from "./Services/blogIDToURL";
import donationURL from "./Services/donationURL";
import { useState } from 'react';

const BlogDetails = () => {

    const { id } = useParams();
    const { data: blog, isPending, error } = useFetch(blogIDToURL(id))
    const navigate = useNavigate();
    const [donationInfo, setDonationInfo] = useState({amount:'', cardNumber: '', cardHolder: '', expiryDate: '', cvv: '', blogID: id});
    const [isLoading, setIsLoading] = useState(false);

    const handleClick = () => {
        fetch(blogIDToURL(blog.id), {
            method:'DELETE'
        }).then(() => {
            navigate('/')
        })
    }

    const handleInputChange = (event) => {
        setDonationInfo({...donationInfo, [event.target.name]: event.target.value});
    }

    const handleFormSubmit = (event) => {
        event.preventDefault();
        setIsLoading(true);
        

        fetch(donationURL(), {
            method: 'POST',
            headers: {"Content-Type":"application/json"},
            body: JSON.stringify(donationInfo)
        }).then(() => {
            console.log('new donation added');
            setIsLoading(false);
            //history.go(-1);
            navigate('/');
        })
    }

    return ( 
        <div className="blog-details">
            {isPending && <div>Loading ...</div>}
            {error && <div>{error}</div>}
            {blog && (
                <article>
                    <h2>{blog.title}</h2>
                    <h3>By {blog.author}</h3>
                    <br />
                    <p><strong>Address: </strong> {blog.address}</p>
                    <p><strong>Hours: </strong> {blog.hours}</p>
                    <p><strong>Phone: </strong> {blog.phone}</p>
                    <p><strong>Email: </strong> {blog.email}</p>
                    <div>{blog.body}</div>
                    <button onClick={handleClick}>delete</button>
                </article>
            )}
            {blog && (
                <div className="create">
                    <form onSubmit={handleFormSubmit}>
                        <h1>Donate now!</h1>
                        <br />
                        <label>Amount (USD):</label>
                        <input type="number" min="0.01" step="0.01" name="amount" value={donationInfo.amount} onChange={handleInputChange} placeholder="Donation Amount" required />
                        <label>Card Holder Name:</label>
                        <input type="text" name="cardHolder" value={donationInfo.cardHolder} onChange={handleInputChange} placeholder="Card Holder" required />
                        <label>Card Number:</label>
                        <input type="number" name="cardNumber" value={donationInfo.cardNumber} onChange={handleInputChange} placeholder="Card Number" required />
                        <label>Expiry Date:</label>
                        <input type="month" name="expiryDate" value={donationInfo.expiryDate} onChange={handleInputChange} placeholder="Expiry Date" required />
                        <label>CVV:</label>
                        <input type="number" name="cvv" value={donationInfo.cvv} onChange={handleInputChange} placeholder="CVV" required />
                        <button type="submit">Donate</button>
                    </form>
                </div>
            )}
            <p>{donationInfo['amount']}</p>
            <p>{donationInfo['cardNumber']}</p>
            <p>{donationInfo['cardHolder']}</p>
            <p>{donationInfo['expiryDate']}</p>
            <p>{donationInfo['cvv']}</p>
            <p>{donationInfo['blogID']}</p>
        </div>
     );
}
 
export default BlogDetails;