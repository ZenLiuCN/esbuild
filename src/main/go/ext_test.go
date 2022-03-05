package main

import (
	"fmt"
	"github.com/evanw/esbuild/pkg/api"
	"strings"
	"testing"
)

func Test_compileJade(t *testing.T) {
	got, err := compileJade(`h(style="color:red") {{中午}}`)
	if err != nil {
		panic(err)
	}
	fmt.Println(got)
}
func BenchmarkName(b *testing.B) {
	for i := 0; i < b.N; i++ {
		_, err := compileJade(`h(style="color:red") {{中午}}`)
		if err != nil {
			panic(err)
		}
	}
}

/*`
const { CSSProperties, defineComponent, PropType }=Vue;
interface Props {
  count: number;
  style: CSSProperties;
}
export default defineComponent({
  props: {
    style: {
      type: Object as PropType<Props["style"]>,
      default: undefined,
    },
    count: {
      type: Number as PropType<Props["count"]>,
      default: undefined,
    },
  },
  emits: ["childClick"],
  setup(props, ctx) {
    const { slots, emit } = ctx;
    return () => (
      <div style={props.style}>
        <h1>This is Child</h1>

        {slots?.header && slots.header()}
        <button onClick={() => emit("childClick")}>Child Count++</button>
        <p>Child count is: {props.count}</p>

        {slots?.default && slots.default()}
        <p>Props' keys are: {Object.keys(props).join(", ")}</p>
      </div>
    );
  },
});
`*/
func TestName(t *testing.T) {
	r := api.Transform(`
const { ref, defineComponent }=Vue;
export default defineComponent({
  setup(props, ctx) {
    const { slots, emit } = ctx;
    const count=ref(0)
    const inc=()=>count.value++
    return () => (
      <div>
        <h1>This is Child</h1>
        <h5>{{count}}</h5>
        <button onClick={inc}>Child Count++</button>
      </div>
    );
  },
});
`, api.TransformOptions{
		Loader:     api.LoaderTSX,
		JSXMode:    api.JSXModeTransform,
		JSXFactory: "h",
		//JSXFragment: ""
	})
	if len(r.Errors) > 0 {
		panic(strings.Join(api.FormatMessages(r.Errors, api.FormatMessagesOptions{}), "\n"))
	}
	fmt.Println(string(r.Code))
}
