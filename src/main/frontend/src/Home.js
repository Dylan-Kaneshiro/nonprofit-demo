import BlogList from "./BlogList";
import useFetch from "./useFetch";
import Cookies from 'js-cookie';

const Home = () => {
  const { error, isPending, data: blogs } = useFetch('http://localhost:8086/blogs/list')
  // Cookies.set('isLoggedIn', 'false', { expires: 7 });
  Cookies.set('isLoggedIn', 'false', { });

  return (
    <div className="home">
      <img src="/images/breadfruit.png" alt="" />
      <h1>Popular</h1>
      { error && <div>{ error }</div> }
      { isPending && <div>Loading...</div> }
      { blogs && <BlogList blogs={blogs} title="Popular"/> }
    </div>
  );
}
 
export default Home;