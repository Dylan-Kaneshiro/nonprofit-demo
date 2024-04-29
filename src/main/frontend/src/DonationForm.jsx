import { useState } from "react";
import donationURL from "./Services/donationURL";
import { useParams, useNavigate } from "react-router-dom";

const DonationForm = ({ id, blog, closeForm }) => {
  const navigate = useNavigate();
  const [isLoading, setIsLoading] = useState(false);
  //   const { id } = useParams();
  const [donationInfo, setDonationInfo] = useState({
    amount: "",
    cardNumber: "",
    cardHolder: "",
    expiryDate: "",
    cvv: "",
    blogID: id,
  });
  // Get the current date in "YYYY-MM" format
  const currentDate = new Date();
  const currentYear = currentDate.getFullYear();
  const currentMonth = currentDate.getMonth() + 2; // Months are 0-indexed
  const minExpiryDate = `${currentYear}-${currentMonth
    .toString()
    .padStart(2, "0")}`;

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

  return (
    <div>
      {blog && (
        <div
          className="create"
          style={{
            flex: "1",
            marginLeft: "5px",
            marginRight: "5px",
            marginTop: "5px",
            marginBottom: "5px",
            backgroundColor: "transparent",
            
          }}
        >
          <form onSubmit={handleFormSubmit}>
            <h1>Donate now!</h1>
            <br />
            <label>Amount (USD):</label>
            <input
              type="number"
              min="0.01"
              step="0.01"
              name="amount"
              value={donationInfo.amount}
              onChange={handleInputChange}
              placeholder="Donation Amount"
              required
            />
            <label>Card Holder Name:</label>
            <input
              type="text"
              name="cardHolder"
              value={donationInfo.cardHolder}
              onChange={handleInputChange}
              placeholder="Card Holder"
              required
            />
            <label>Card Number:</label>
            <input
              type="number"
              min="1000000000000000"
              max="9999999999999999"
              name="cardNumber"
              value={donationInfo.cardNumber}
              onChange={handleInputChange}
              placeholder="Card Number"
              required
            />
            <label>Expiry Date:</label>
            <input
              type="month"
              name="expiryDate"
              min={minExpiryDate}
              value={donationInfo.expiryDate}
              onChange={handleInputChange}
              placeholder="Expiry Date"
              required
            />
            <label>CVV:</label>
            <input
              type="number"
              name="cvv"
              min="000"
              max="999"
              step="1"
              value={donationInfo.cvv}
              onChange={handleInputChange}
              placeholder="CVV"
              required
            />
            <button type="submit">Donate</button>
            <button onClick={closeForm}>Close</button>
            <p>{donationInfo["amount"]}</p>
            <p>{donationInfo["cardNumber"]}</p>
            <p>{donationInfo["cardHolder"]}</p>
            <p>{donationInfo["expiryDate"]}</p>
            <p>{donationInfo["cvv"]}</p>
            <p>{donationInfo["blogID"]}</p>
          </form>
        </div>
      )}
    </div>
  );
};

export default DonationForm;
