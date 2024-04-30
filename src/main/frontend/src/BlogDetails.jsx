import { useParams, useNavigate } from "react-router-dom";
import useFetch from "./useFetch";
import blogIDToURL from "./Services/blogIDToURL";
import donationURL from "./Services/donationURL";
import DonationForm from "./DonationForm";
import { useState } from "react";
import { useEffect } from "react";
import { useCookie } from "react-use";
import { useAllowed } from "./util/useAllowed";
import Modal from "react-modal";

const BlogDetails = () => {
  const { id } = useParams();
  const { data: blog, isPending, error } = useFetch(blogIDToURL(id));
  const navigate = useNavigate();
  const [donationInfo, setDonationInfo] = useState({
    amount: "",
    cardNumber: "",
    cardHolder: "",
    expiryDate: "",
    cvv: "",
    blogID: id,
  });
  const [showDonationForm, setShowDonationForm] = useState(false);
  const [isLoading, setIsLoading] = useState(false);
  //auth cookie
  const { isAllowed } = useAllowed();

  // Get the current date in "YYYY-MM" format
  const currentDate = new Date();
  const currentYear = currentDate.getFullYear();
  const currentMonth = currentDate.getMonth() + 2; // Months are 0-indexed
  const minExpiryDate = `${currentYear}-${currentMonth
    .toString()
    .padStart(2, "0")}`;

  const handleClick = () => {
    fetch(blogIDToURL(blog.id), {
      method: "DELETE",
    }).then(() => {
      navigate("/");
    });
  };

  const handleInputChange = (event) => {
    setDonationInfo({
      ...donationInfo,
      [event.target.name]: event.target.value,
    });
  };

  const handleFormSubmit = (event) => {
    event.preventDefault();
    setIsLoading(true);

    fetch(donationURL(), {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(donationInfo),
    }).then(() => {
      console.log("new donation added");
      setIsLoading(false);
      //history.go(-1);
      navigate("/");
    });
  };
  // const handleToggleActive = () => {
  //   const updatedBlog = { ...blog, active: !blog.active };

  //   fetch(blogIDToURL(blog.id), {
  //     method: "PUT",
  //     headers: { "Content-Type": "application/json" },
  //     body: JSON.stringify(updatedBlog),
  //   })
  //     .then((response) => response.json())
  //     .then((data) => {
  //       setBlog(data);
  //     });
  // };

  return (
    <div
      className="blog-details"
      style={{
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        height: "100vh",
      }}
    >
      {isPending && <div>Loading ...</div>}
      {error && <div>{error}</div>}
      {blog && (
        <article
          style={{
            flex: "1",
            marginLeft: "5px",
            marginRight: "5px",
            marginTop: "5px",
            marginBottom: "5px",
            backgroundColor: "transparent",
            padding: "20px",
            borderRadius: "15px",
            // boxShadow: "0 0 10px 2px rgba(0, 0, 0, 0.1)",
          }}
        >
          <h2 style={{ marginBottom: "10px" }}>{blog.title}</h2>
          <h3 style={{ color: "#888", marginBottom: "20px" }}>
            By {blog.author}
          </h3>
          <div style={{ marginBottom: "20px" }}>
            <p>
              <strong>Address: </strong> {blog.address}
            </p>
            <p>
              <strong>City: </strong> {blog.city}
            </p>
            <p>
              <strong>Hours: </strong> {blog.hours}
            </p>
            <p>
              <strong>Phone: </strong> {blog.phone}
            </p>
            <p>
              <strong>Email: </strong> {blog.email}
            </p>
          </div>
          <p style={{ marginBottom: "20px" }}>
            <strong>Total funds raised: </strong> {blog.funds}
          </p>
          <div style={{ marginBottom: "20px" }}>{blog.body}</div>
          {/* <button
            style={{
              padding: "10px 20px",
              backgroundColor: "#ff6347",
              color: "#fff",
              border: "none",
              borderRadius: "5px",
              cursor: "pointer",
            }}
            onClick={handleClick}
          >
            delete
          </button> */}
          {/*<input
            type="checkbox"
            checked={blog.active}
            // onChange={handleToggleActive}
            style={{
              cursor: "pointer",
            }}
          />
          <label>{blog.active ? "Active" : "Inactive"}</label>*/}
        </article>
      )}
      {/* <div
        style={{
          // flex: "1",
          widthq: "20%",
          margin : "0 auto",
          height: "auto",
          display: "flex",
          flexDirection: "column",
          padding: "20px",
          borderRadius: "15px",
          backgroundColor: "transparent",
          boxShadow: "0 0 10px 2px rgba(0, 0, 0, 0.1)",
          // boxShadow: "0 0 10px 2px rgba(0, 0, 0, 0.1)",
        }}
      > */}
        {/* <p style={{ marginBottom: "20px" }}>
          <strong>Total funds raised: $</strong> {blog.funds || 100}
        </p> */}

        <button onClick={() => setShowDonationForm(true)}>
          Show Donation Form
        </button>
      {/* </div> */}
      <Modal
        isOpen={showDonationForm}
        onRequestClose={() => setShowDonationForm(false)}
        contentLabel="Donation Form"
        appElement={document.getElementById("root")}
        style={{
          overlay: {
            backgroundColor: "rgba(0, 0, 0, 0.75)", // This is a black overlay with 75% opacity
          },
          content: {
            top: "50%",
            left: "50%",
            right: "auto",
            bottom: "auto",
            marginRight: "50%",
            transform: "translate(-50%, -50%)",
            backgroundColor: "#fff", // This is a white background for the modal content
            // border: '1px solid #ccc', // This is a gray border for the modal content
            borderRadius: "15px", // This is a 4px border radius for the modal content
            padding: "0px", // This is a 20px padding for the modal content
            // maxWidth: '600px', // This is the maximum width of the modal content
            width: "20%", // This is the width of the modal content
            boxShadow: "0 0 10px 2px rgba(0, 0, 0, 0.1)", // This is a glow effect for the modal content
            // overflow: 'auto',
          },
        }}
      >
        <DonationForm
          id={id}
          blog={blog}
          closeForm={() => setShowDonationForm(false)}
        />
        {/* <button onClick={() => setShowDonationForm(false)}>Close</button> */}
      </Modal>
    </div>
  );
};

export default BlogDetails;
