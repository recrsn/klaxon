import { useService } from 'Frontend/hooks/services';
import { useParams } from 'react-router-dom';

export default function ServiceDetailPage() {
  const { key } = useParams<{ key: string }>();
  const { data, isLoading } = useService(key!);

  return (
    <>
      <h1>Service</h1>
      {isLoading && <p>Loading...</p>}
      {data && (
        <>
          <h2>
            {data.name} ({data.key})
          </h2>
        </>
      )}
    </>
  );
}
