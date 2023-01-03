import { useQuery } from '@tanstack/react-query';
import { ComponentEndpoint } from '../generated/endpoints';

export function useComponents(serviceId: string) {
  const { data, error, isLoading } = useQuery({
    queryKey: ['components', serviceId],
    queryFn: () => ComponentEndpoint.list(serviceId),
  });
  return { data, error, isLoading };
}
