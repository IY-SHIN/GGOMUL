import { Helmet, HelmetProvider } from 'react-helmet-async';

function SEO({ title }) {
    return (
        <HelmetProvider>
            <Helmet>
                <title>{title} | 꼬물이 🍞</title>
            </Helmet>
        </HelmetProvider>
    )
}

export default SEO;