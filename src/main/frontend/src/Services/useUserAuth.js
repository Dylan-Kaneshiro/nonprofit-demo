import useFetch from "../useFetch";

const useUserAuth = (email) => {
    return useFetch(`http://localhost:8086/api/v1/auth/${email}`)
}

export default useUserAuth;


