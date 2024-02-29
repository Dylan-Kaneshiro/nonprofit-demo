import BlogList from "./BlogList";
import useFetch from "./useFetch";

const Home = () => {
  const { error, isPending, data: blogs } = useFetch('http://localhost:8086/blogs/list')

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