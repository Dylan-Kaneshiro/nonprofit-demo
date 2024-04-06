import BlogList from "./BlogList";
import useBlogs from "./Services/useBlogs";

const Home = () => {
  const { error, isPending, data: blogs } = useBlogs("")

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