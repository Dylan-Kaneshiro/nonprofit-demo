// useAllowed.js
import { useState, useEffect } from 'react';
import { useCookies } from 'react-cookie';
import Cookies from 'js-cookie';

export const useAllowed = () => {
  const [cookies] = useCookies(['isAllowed']);
  const [isAllowed, setIsAllowed] = useState(false);

  useEffect(() => {
    if (cookies.isAllowed) {
      setIsAllowed(true);
    } else {
      setIsAllowed(false);
    }
  }, [cookies.isAllowed]);


  return {isAllowed};
};
