import { useEffect, useState, useRef } from 'react'
import axios from 'axios';

import { BASE_URL } from './../config/config';

export const useApi = () => {

    /*
        Esta variable puede ser cambiada
        Sin volver a renderizar el componente
    */
    const isMounted = useRef(true);

    const [response, setResponse] = useState([]);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState({ message: "" });

    useEffect(() => {
        //Cambio a false cuando se desturye el componente
        return () => {
            isMounted.current = false;
        }
    }, [])

    const callApi = (formData) => {

        setLoading(true);
        setError({ message: "" });
        axios.post(
            `${BASE_URL}/api/face-recognition/upload`,
            formData,
            {
                headers: {
                    "Content-type": "multipart/form-data",
                },
            }
        )
            .then(res => {
                if (isMounted.current) {
                    if (res) {
                        console.log(res.data);
                        setResponse(res.data);
                        setLoading(false)
                    } else {
                        setError({ message: "Not Found" })
                        setLoading(false)
                    }
                }
            })
            .catch(err => {
                console.log(err);
                const out = `Ubo un error: ${err}`;
                setError({ message: out })
                setLoading(false)
            })
    }

    return { response, loading, error, callApi };
}
